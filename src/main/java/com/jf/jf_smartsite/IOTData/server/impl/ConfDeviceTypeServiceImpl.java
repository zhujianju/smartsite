package com.jf.jf_smartsite.IOTData.server.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jf.jf_smartsite.IOTData.entity.ConfDevicetype;

import com.jf.jf_smartsite.IOTData.mapper.ConfDeviceTypeMapper;

import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
import com.jf.jf_smartsite.IOTData.server.ConfDeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class ConfDeviceTypeServiceImpl implements ConfDeviceTypeService {
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
    public PageResult findPage(int pageNum, int pageSize, ConfDevicetype confDevicetype) {
        PageHelper.startPage(pageNum,pageSize,true);
        Example example=new Example(ConfDevicetype.class);
        Example.Criteria criteria = example.createCriteria();
        //如果传入的对象不为null
        if(confDevicetype !=null){
            if(confDevicetype.getName() !=null && confDevicetype.getName().length()>0){
                criteria.andLike("name","%"+confDevicetype.getName()+"%");
            }
        }
        Page<ConfDevicetype> page  = (Page<ConfDevicetype>) confDeviceTypeMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
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
        Example example = new Example(ConfDevicetype.class);
        example.createCriteria().andEqualTo("id",id);
        return  confDeviceTypeMapper.deleteByExample(example);
    }

    @Override
    public int updateByid(ConfDevicetype confDevicetype) {
        Example example = new Example(ConfDevicetype.class);
        example.createCriteria().andEqualTo("id", confDevicetype.getId());
        return confDeviceTypeMapper.updateByExampleSelective(confDevicetype,example);
    }

    @Override
    public int insert(ConfDevicetype confDevicetype) {
        return confDeviceTypeMapper.insert(confDevicetype);
    }


}
