package com.jf.jf_smartsite.IOTData.server.impl;

import com.jf.jf_smartsite.IOTData.mapper.ConfDeviceMapper;
import com.jf.jf_smartsite.IOTData.server.ConfDeviceService;
import com.jf.jf_smartsite.IOTData.entity.ConfDevice;
import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class ConfDeviceTypeImpl implements ConfDeviceService {
    @Autowired
    private ConfDeviceMapper confDeviceMapper;

    @Override
    public List<ConfDevice> findAll() {
        List<ConfDevice> confDeviceTypes = confDeviceMapper.selectAll();
        return confDeviceTypes;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize, ConfDevice confDevice) {
        return null;
    }

    @Override
    public ConfDevice findOne(Integer id) {
        Example example=new Example(ConfDevice.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",id);
        return  confDeviceMapper.selectOneByExample(example);
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public int updateByid(ConfDevice confDevice) {
        return 0;
    }

    @Override
    public int insert(ConfDevice confDevice) {
        return 0;
    }
}
