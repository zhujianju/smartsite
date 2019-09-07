package com.jf.jf_smartsite.gen.mapper;


import com.jf.jf_smartsite.gen.domain.Prototype;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface  EqGenTableMapper {
    /**
     * 查询设备原型信息
     *
     * @return 设备原型信息
     */
    public Prototype selectGenTable();

}
