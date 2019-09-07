package com.jf.jf_smartsite.IOTData.server.impl;

import com.jf.jf_smartsite.entity.IOTData.ConfCommunicate;
import com.jf.jf_smartsite.entity.comEntity.PageResult;
import com.jf.jf_smartsite.IOTData.mapper.ConfCommunicateMapper;
import com.jf.jf_smartsite.IOTData.server.ConfCommunicateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ConfCommunicateTypeImpl implements ConfCommunicateService {
    @Autowired
    private ConfCommunicateMapper confCommunicateMapper;

    @Override
    public List<ConfCommunicate> findAll() {
        return confCommunicateMapper.selectAll();
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
    public ConfCommunicate findOne(Integer id) {
        Example example=new Example(ConfCommunicate.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",id);
        return  confCommunicateMapper.selectOneByExample(example);
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public int updateByid(ConfCommunicate confCommunicate) {
        return 0;
    }

    @Override
    public int insert(ConfCommunicate confCommunicate) {
        return 0;
    }
}
