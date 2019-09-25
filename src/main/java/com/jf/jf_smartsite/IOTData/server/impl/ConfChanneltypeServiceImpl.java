package com.jf.jf_smartsite.IOTData.server.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jf.jf_smartsite.IOTData.entity.ConfChanneltype;
import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
import com.jf.jf_smartsite.IOTData.mapper.ConfChanneltypeMapper;
import com.jf.jf_smartsite.IOTData.server.ConfChanneltypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class ConfChanneltypeServiceImpl implements ConfChanneltypeService {
    @Autowired
    private ConfChanneltypeMapper confChanneltypeMapper;

    @Override
    public List<ConfChanneltype> findAll() {
        return confChanneltypeMapper.selectAll();
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize,true);

        Page<ConfChanneltype> page = (Page<ConfChanneltype>) confChanneltypeMapper.selectAll();
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize, ConfChanneltype confChanneltype) {
        PageHelper.startPage(pageNum,pageSize,true);
        Example example=new Example(ConfChanneltype.class);
        Example.Criteria criteria = example.createCriteria();
        //如果传入的对象不为null
        if(confChanneltype !=null){
            if(confChanneltype.getChannelname() !=null && confChanneltype.getChannelname().length()>0){
                criteria.andLike("channelname","%"+confChanneltype.getChannelname()+"%");
            }
            //DeviceTypeId设备类型
            if(confChanneltype.getDevicetypeid() != null) {
                criteria.andEqualTo("devicetypeid",confChanneltype.getDevicetypeid());
            }

        }
        Page<ConfChanneltype> page  = (Page<ConfChanneltype>) confChanneltypeMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public ConfChanneltype findOne(Integer id) {
        Example example=new Example(ConfChanneltype.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",id);
        return  confChanneltypeMapper.selectOneByExample(example);
    }

    @Override
    public int deleteById(Integer id) {
        Example example = new Example(ConfChanneltype.class);
        example.createCriteria().andEqualTo("id",id);
        return  confChanneltypeMapper.deleteByExample(example);
    }

    @Override
    public int updateByid(ConfChanneltype confChanneltype) {

        Example example = new Example(ConfChanneltype.class);
        example.createCriteria().andEqualTo("id", confChanneltype.getId());
        return confChanneltypeMapper.updateByExampleSelective(confChanneltype,example);
    }

    @Override
    public int insert(ConfChanneltype confChanneltype) {
            return confChanneltypeMapper.insert(confChanneltype);
    }


    @Override
    public List<ConfChanneltype> findChannelTypeByDeviceId(Integer id) {
        Example example = new Example(ConfChanneltype.class);
        example.createCriteria().andEqualTo("devicetypeid", id);
        List<ConfChanneltype> confChanneltypes = confChanneltypeMapper.selectByExample(example);
        return confChanneltypes;
    }
}
