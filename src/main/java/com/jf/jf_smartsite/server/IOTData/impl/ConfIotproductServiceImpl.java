package com.jf.jf_smartsite.server.IOTData.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jf.jf_smartsite.entity.IOTData.ConfIotproduct;
import com.jf.jf_smartsite.entity.IOTData.ConfStation;
import com.jf.jf_smartsite.entity.comEntity.PageResult;
import com.jf.jf_smartsite.mapper.IOTData.ConfIotproductMapper;
import com.jf.jf_smartsite.mapper.IOTData.ConfStationMapper;
import com.jf.jf_smartsite.server.IOTData.ConfIotproductService;
import com.jf.jf_smartsite.server.IOTData.ConfStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ConfIotproductServiceImpl implements ConfIotproductService {
    @Autowired
    private ConfIotproductMapper confIotproductMapper;

    @Override
    public List<ConfIotproduct> findAll() {
        List<ConfIotproduct> confIotproducts = confIotproductMapper.selectAll();
        return confIotproducts;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize,true);

        Page<ConfIotproduct> page = (Page<ConfIotproduct>) confIotproductMapper.selectAll();
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize, String name) {
        PageHelper.startPage(pageNum,pageSize,true);
        Example example=new Example(ConfStation.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name","%"+name+"%");
        Page<ConfIotproduct> page  = (Page<ConfIotproduct>) confIotproductMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public ConfIotproduct findOne(Integer id) {
        return  confIotproductMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Integer id) {
        Example example = new Example(ConfStation.class);
        example.createCriteria().andEqualTo("id",id);
        return  confIotproductMapper.deleteByExample(example);
    }

    @Override
    public int updateByid(ConfIotproduct confIotproduct) {
        Example example = new Example(ConfStation.class);
        example.createCriteria().andEqualTo("id", confIotproduct.getId());
        return confIotproductMapper.updateByExampleSelective(confIotproduct,example);
    }

    @Override
    public int insert(ConfIotproduct confIotproduct) {
        return confIotproductMapper.insert(confIotproduct);
    }
}
