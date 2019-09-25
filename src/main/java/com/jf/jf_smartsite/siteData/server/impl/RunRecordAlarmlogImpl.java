package com.jf.jf_smartsite.siteData.server.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
import com.jf.jf_smartsite.siteData.entity.RunRecordAlarmlog;
import com.jf.jf_smartsite.siteData.mapper.RunRecordAlarmMapper;
import com.jf.jf_smartsite.siteData.server.RunRecordAlarmServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class RunRecordAlarmlogImpl implements RunRecordAlarmServer {
   @Autowired
    private RunRecordAlarmMapper runRecordAlarmMapper;


    @Override
    public List<RunRecordAlarmlog> findAll() {
        return null;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize, RunRecordAlarmlog runRecordAlarmlog) {
        PageHelper.startPage(pageNum,pageSize,true);
        Example example=new Example(RunRecordAlarmlog.class);
        Example.Criteria criteria = example.createCriteria();
        //如果传入的查询条件不为Null;
        if(runRecordAlarmlog!=null){
            //如果名字不为空
            if(runRecordAlarmlog.getEventname() != null && runRecordAlarmlog.getEventname().length()>0){
                criteria.andLike("eventname","%"+runRecordAlarmlog.getEventname()+"%");
            }
            //根据站点来查询
            if(runRecordAlarmlog.getStationid() != null  ){
                criteria.andEqualTo("stationid",runRecordAlarmlog.getStationid());
            }
            //根据设备查询
            if(runRecordAlarmlog.getDeviceid() != null){
                criteria.andEqualTo("deviceid",runRecordAlarmlog.getDeviceid());
            }
            //DeviceTypeId设备类型
            if(runRecordAlarmlog.getDevicetypeid() != null) {
                criteria.andEqualTo("devicetypeid",runRecordAlarmlog.getDevicetypeid());
            }
        }
        Page<RunRecordAlarmlog> page = (Page<RunRecordAlarmlog>) runRecordAlarmMapper.selectByExample(example);

        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public RunRecordAlarmlog findOne(Integer id) {
        return null;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public int updateByid(RunRecordAlarmlog runRecordAlarmlog) {
        return 0;
    }

    @Override
    public int insert(RunRecordAlarmlog runRecordAlarmlog) {
        return 0;
    }
}
