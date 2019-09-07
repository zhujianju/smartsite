package com.jf.jf_smartsite.IOTData.server.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jf.jf_smartsite.IOTData.entity.ConfStation;
import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
import com.jf.jf_smartsite.IOTData.mapper.ConfStationMapper;
import com.jf.jf_smartsite.IOTData.server.ConfStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class ConfStationServiceImpl implements ConfStationService {
    @Autowired
    private ConfStationMapper confStationMapper;

    @Override
    public List<ConfStation> findAll() {
        List<ConfStation> confStations = confStationMapper.selectAll();
        return confStations;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize,true);

        Page<ConfStation> page = (Page<ConfStation>) confStationMapper.selectAll();
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize, ConfStation confStation) {
        PageHelper.startPage(pageNum,pageSize,true);
        Example example=new Example(ConfStation.class);
        Example.Criteria criteria = example.createCriteria();
        //如果传入的对象不为null
        if(confStation !=null){
            if(confStation.getName() !=null && confStation.getName().length()>0){
                criteria.andLike("name","%"+confStation.getName()+"%");
            }
        }
        Page<ConfStation> page  = (Page<ConfStation>) confStationMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public ConfStation findOne(Integer id){
        Example example=new Example(ConfStation.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",id);
        return  confStationMapper.selectOneByExample(example);
    }

    @Override
    public int deleteById(Integer id) {
        Example example = new Example(ConfStation.class);
        example.createCriteria().andEqualTo("id",id);
        return  confStationMapper.deleteByExample(example);
    }



    @Override
    public int updateByid(ConfStation confStation) {
        Example example = new Example(ConfStation.class);
        example.createCriteria().andEqualTo("id", confStation.getId());
        return confStationMapper.updateByExampleSelective(confStation,example);
    }

    @Override
    public int insert(ConfStation confStation) {
        return confStationMapper.insert(confStation);
    }

    @Override
    public List<ConfStation> findStationByIOTid(Integer iotId) {
        Example example = new Example(ConfStation.class);
        example.createCriteria().andEqualTo("iottypeid",iotId);
        return confStationMapper.selectByExample(example);
    }
}
