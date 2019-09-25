package com.jf.jf_smartsite.tmpvalue.service;

import com.jf.jf_smartsite.tmpvalue.domain.Tmpvalue;

import java.util.List;

public interface TmpValueService {
    //查询历史扬尘数据
    public List<Tmpvalue> selectListTmpValue();

}

