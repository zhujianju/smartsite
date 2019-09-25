package com.jf.jf_smartsite.tmpvalue.mapper;

import com.jf.jf_smartsite.tmpvalue.domain.Tmpvalue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TmpValueDao {
    //查询历史扬尘数据
    public List<Tmpvalue> selectListTmpValue();
}
