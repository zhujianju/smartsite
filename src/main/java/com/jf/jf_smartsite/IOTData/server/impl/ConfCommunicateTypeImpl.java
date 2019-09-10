package com.jf.jf_smartsite.IOTData.server.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jf.jf_smartsite.IOTData.entity.ConfCommunicate;
import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
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
    public PageResult findPage(int pageNum, int pageSize, ConfCommunicate confCommunicate) {
        PageHelper.startPage(pageNum,pageSize,true);
        Example example=new Example(ConfCommunicate.class);
        Example.Criteria criteria = example.createCriteria();
        //如果传入的对象不为null
        if(confCommunicate !=null){
            if(confCommunicate.getName() !=null && confCommunicate.getName().length()>0){
                criteria.andLike("name","%"+confCommunicate.getName()+"%");
            }
        }
        Page<ConfCommunicate> page  = (Page<ConfCommunicate>) confCommunicateMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
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
        Example example = new Example(ConfCommunicate.class);
        example.createCriteria().andEqualTo("id",id);
        return  confCommunicateMapper.deleteByExample(example);
    }

    @Override
    public int updateByid(ConfCommunicate confCommunicate) {
        Example example = new Example(ConfCommunicate.class);
        example.createCriteria().andEqualTo("id", confCommunicate.getId());
        return confCommunicateMapper.updateByExampleSelective(confCommunicate,example);
    }

    @Override
    public int insert(ConfCommunicate confCommunicate) {
        return confCommunicateMapper.insert(confCommunicate);
    }
}
