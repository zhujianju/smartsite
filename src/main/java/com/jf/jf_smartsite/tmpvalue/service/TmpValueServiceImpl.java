package com.jf.jf_smartsite.tmpvalue.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
import com.jf.jf_smartsite.siteData.entity.RunRecordAlarmlog;
import com.jf.jf_smartsite.tmpvalue.domain.Tmpvalue;
import com.jf.jf_smartsite.tmpvalue.mapper.TmpValueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class TmpValueServiceImpl implements TmpValueService {
    //查询历史扬尘数据
    @Autowired
    TmpValueDao tmpValueDao;
    @Override
    public List<Tmpvalue> findAll() {
        return null;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize, Tmpvalue tmpvalue) {
        PageHelper.startPage(pageNum,pageSize,true);
        Example example=new Example(Tmpvalue.class);
        Example.Criteria criteria = example.createCriteria();//创建sql条件语句 必须全小写
        //如果传入的查询条件不为Null;
        if(tmpvalue!=null){
            //根据站点来查询
            if(tmpvalue.getStationid() != 0  ){
                criteria.andEqualTo("stationid",tmpvalue.getStationid());
            }
            //根据设备查询
            if(tmpvalue.getDeviceid() != 0){
                criteria.andEqualTo("deviceid",tmpvalue.getDeviceid());
            }
            //DeviceTypeId设备类型
            if(tmpvalue.getDevicetypeid() != 0) {
                criteria.andEqualTo("devicetypeid",tmpvalue.getDevicetypeid());
            }
        }
        Page<Tmpvalue> page = (Page<Tmpvalue>) tmpValueDao.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public Tmpvalue findOne(Integer id) {
        return null;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public int updateByid(Tmpvalue tmpvalue) {
        return 0;
    }

    @Override
    public int insert(Tmpvalue tmpvalue) {
        return 0;
    }
}
