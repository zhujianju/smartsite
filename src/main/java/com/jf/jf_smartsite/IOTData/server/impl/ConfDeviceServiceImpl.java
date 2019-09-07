package com.jf.jf_smartsite.IOTData.server.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jf.jf_smartsite.IOTData.entity.ConfDevice;
import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
import com.jf.jf_smartsite.IOTData.mapper.ConfDeviceMapper;
import com.jf.jf_smartsite.IOTData.server.ConfDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ConfDeviceServiceImpl implements ConfDeviceService {
    @Autowired
    private ConfDeviceMapper confDeviceMapper;

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
        criteria.andLike("name","%"+confDevice.getName()+"%");
        Page<ConfDevice> page  = (Page<ConfDevice>) confDeviceMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
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
        example.createCriteria().andEqualTo("DeviceId",id);
        return  confDeviceMapper.deleteByExample(example);
    }

    @Override
    public int updateByid(ConfDevice confDevice) {
        Example example = new Example(ConfDevice.class);
        example.createCriteria().andEqualTo("Deviceid", confDevice.getDeviceid());
        return confDeviceMapper.updateByExampleSelective(confDevice,example);
    }

    @Override
    public int insert(ConfDevice confDevice) {
        return confDeviceMapper.insert(confDevice);
    }
}
