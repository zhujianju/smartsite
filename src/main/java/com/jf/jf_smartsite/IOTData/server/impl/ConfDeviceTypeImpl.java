package com.jf.jf_smartsite.IOTData.server.impl;

import com.jf.jf_smartsite.entity.IOTData.ConfDevicetype;
import com.jf.jf_smartsite.entity.comEntity.PageResult;
import com.jf.jf_smartsite.IOTData.mapper.ConfDeviceTypeMapper;
import com.jf.jf_smartsite.IOTData.server.ConfDeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class ConfDeviceTypeImpl implements ConfDeviceTypeService {
    @Autowired
    private ConfDeviceTypeMapper confDeviceTypeMapper;

    @Override
    public List<ConfDevicetype> findAll() {
        List<ConfDevicetype> confDeviceTypes = confDeviceTypeMapper.selectAll();
        return confDeviceTypes;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize, String name) {
        return null;
    }

    @Override
    public ConfDevicetype findOne(Integer id) {
        Example example=new Example(ConfDevicetype.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",id);
        return  confDeviceTypeMapper.selectOneByExample(example);
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public int updateByid(ConfDevicetype confDeviceType) {
        return 0;
    }

    @Override
    public int insert(ConfDevicetype confDeviceType) {
        return 0;
    }
}
