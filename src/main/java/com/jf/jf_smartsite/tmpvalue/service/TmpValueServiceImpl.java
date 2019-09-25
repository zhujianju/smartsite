package com.jf.jf_smartsite.tmpvalue.service;

import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;
import com.jf.jf_smartsite.tmpvalue.domain.Tmpvalue;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TmpValueServiceImpl implements TmpValueService {
    //查询历史扬尘数据

    @Override
    public List<Tmpvalue> findAll() {
        return null;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize, Tmpvalue tmpvalue) {


        return null;
    }

    @Override
    public Tmpvalue findOne(Integer id) {
        return null;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public int updateByid(Tmpvalue tmpvalue) {
        return 0;
    }

    @Override
    public int insert(Tmpvalue tmpvalue) {
        return 0;
    }
}
