package com.jf.jf_smartsite.IOTData.server.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jf.jf_smartsite.IOTData.entity.SvrConfParam;
import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
import com.jf.jf_smartsite.IOTData.mapper.SvrConfParamMapper;
import com.jf.jf_smartsite.IOTData.server.SvrConfParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class SvrConfParamServiceImpl implements SvrConfParamService {
    @Autowired
    private SvrConfParamMapper svrConfParamMapper;


    @Override
    public List<SvrConfParam> findAll() {
        List<SvrConfParam> svrConfParams = svrConfParamMapper.selectAll();
        return svrConfParams;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize,true);

        Page<SvrConfParam> page = (Page<SvrConfParam>) svrConfParamMapper.selectAll();
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize, SvrConfParam svrConfParam) {
        PageHelper.startPage(pageNum,pageSize,true);
        Example example=new Example(SvrConfParam.class);
        Example.Criteria criteria = example.createCriteria();
        //如果传入的对象不为null
        if(svrConfParam !=null){
            if(svrConfParam.getItem() !=null && svrConfParam.getItem().length()>0){
                criteria.andLike("item","%"+svrConfParam.getItem()+"%");
            }
        }
        Page<SvrConfParam> page  = (Page<SvrConfParam>) svrConfParamMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public SvrConfParam findOne(Integer id) {
        return null;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public SvrConfParam findOne(String key) {
        Example example=new Example(SvrConfParam.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("keyz",key);
        return  svrConfParamMapper.selectOneByExample(example);
    }

    @Override
    public int deleteById(String key) {
        Example example = new Example(SvrConfParam.class);
        example.createCriteria().andEqualTo("keyz",key);
        return  svrConfParamMapper.deleteByExample(example);
    }

    @Override
    public int updateByid(SvrConfParam svrConfParam) {
        Example example = new Example(SvrConfParam.class);
        example.createCriteria().andEqualTo("keyz", svrConfParam.getKeyz());
        return svrConfParamMapper.updateByExampleSelective(svrConfParam,example);
    }

    @Override
    public int insert(SvrConfParam svrConfParam) {
        return svrConfParamMapper.insert(svrConfParam);
    }
}
