package com.jf.jf_smartsite.IOTData.server.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jf.jf_smartsite.IOTData.entity.ConfCommunicate;
import com.jf.jf_smartsite.IOTData.entity.ConfDevice;
import com.jf.jf_smartsite.IOTData.entity.ConfDevicetype;
import com.jf.jf_smartsite.IOTData.entity.ConfStation;
import com.jf.jf_smartsite.IOTData.entity.comEntity.ConfDeviceDTypeDCom;
import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
import com.jf.jf_smartsite.IOTData.mapper.ConfCommunicateMapper;
import com.jf.jf_smartsite.IOTData.mapper.ConfDeviceMapper;
import com.jf.jf_smartsite.IOTData.mapper.ConfDeviceTypeMapper;
import com.jf.jf_smartsite.IOTData.server.ConfCommunicateService;
import com.jf.jf_smartsite.IOTData.server.ConfDeviceService;
import com.jf.jf_smartsite.IOTData.server.ConfDeviceTypeService;
import com.jf.jf_smartsite.IOTData.server.ConfStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConfDeviceServiceImpl implements ConfDeviceService {
    @Autowired
    private ConfDeviceMapper confDeviceMapper;
    @Autowired
    private ConfDeviceTypeService confDeviceTypeService;
    @Autowired
    private ConfCommunicateService confCommunicateService;
    @Autowired
    private ConfStationService confStationService;

    @Override
    public List<ConfDevice> findAll() {
        List<ConfDevice> ConfDevices = confDeviceMapper.selectAll();
        return ConfDevices;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize,true);

        Page<ConfDevice> page = (Page<ConfDevice>) confDeviceMapper.selectAll();
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize, ConfDevice confDevice) {
        PageHelper.startPage(pageNum,pageSize,true);
        Example example=new Example(ConfDevice.class);
        Example.Criteria criteria = example.createCriteria();
        //如果传入的对象不为null
        if(confDevice !=null){
            if(confDevice.getName() !=null && confDevice.getName().length()>0){
                criteria.andLike("name","%"+confDevice.getName()+"%");
            }
            if(confDevice.getDeviceid() != null){
                criteria.andEqualTo("deviceid",confDevice.getDeviceid());
            }
        }

        Page<ConfDevice> page = (Page<ConfDevice>) confDeviceMapper.selectByExample(example);
        List<ConfDevice> result = page.getResult();
        //定义集合用于接收总结果集
        List<ConfDeviceDTypeDCom> totalList=null;
        //如果查到了结果.则查询
        //查询类型和通讯模式
        if(result.size()>0){
            totalList= findDeviceTypandCommon(result);
        }

        return new PageResult(page.getTotal(),totalList);
    }

    @Override
    public ConfDevice findOne(Integer id) {
        Example example=new Example(ConfDevice.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deviceid",id);
        return  confDeviceMapper.selectOneByExample(example);
    }

    @Override
    public int deleteById(Integer id) {
        Example example = new Example(ConfDevice.class);
        example.createCriteria().andEqualTo("deviceid",id);
        return  confDeviceMapper.deleteByExample(example);
    }

    @Override
    public int updateByid(ConfDevice confDevice) {
        Example example = new Example(ConfDevice.class);
        example.createCriteria().andEqualTo("deviceid", confDevice.getDeviceid());
        return confDeviceMapper.updateByExampleSelective(confDevice,example);
    }

    @Override
    public int insert(ConfDevice confDevice) {
        return confDeviceMapper.insert(confDevice);
    }

    @Override
    public List<ConfDeviceDTypeDCom> findDeviceByStationId(Integer id) {
        Example example = new Example(ConfDevice.class);
        example.createCriteria().andEqualTo("stationid", id);
        List<ConfDevice> confDevices = confDeviceMapper.selectByExample(example);
        List<ConfDeviceDTypeDCom> deviceTypandCommons = findDeviceTypandCommon(confDevices);
        return deviceTypandCommons;
    }

    /**
     * 通用的,查询设备分类和通讯的方法
     */
    private List<ConfDeviceDTypeDCom> findDeviceTypandCommon(List<ConfDevice> list){
        List<ConfDeviceDTypeDCom> totalList=new ArrayList<ConfDeviceDTypeDCom>();
        for (ConfDevice conf:list) {
            ConfDeviceDTypeDCom confDeviceDTypeDCom = new ConfDeviceDTypeDCom();
            ConfDevicetype deviceType = confDeviceTypeService.findOne(conf.getTypeid());//查询分类
            ConfCommunicate commu = confCommunicateService.findOne(conf.getCommunicateid());//查询通讯
            ConfStation station = confStationService.findOne(conf.getStationid());//查询站点
            confDeviceDTypeDCom.setConfDevice(conf);
            confDeviceDTypeDCom.setStationName(station.getName());
            confDeviceDTypeDCom.setConfDevicetype(deviceType);
            confDeviceDTypeDCom.setConfCommunicate(commu);
            totalList.add(confDeviceDTypeDCom);
        }
        return totalList;
    }
}
