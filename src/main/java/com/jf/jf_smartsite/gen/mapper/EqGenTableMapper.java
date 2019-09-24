package com.jf.jf_smartsite.gen.mapper;


import com.jf.jf_smartsite.gen.domain.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EqGenTableMapper {
    /**
     * 查询设备原型信息
     *
     * @return 设备原型信息
     */
    Devices selectGenTable(int id);

    List<ServiceTypeCapabilitie> selectGenTableByid(int id);

    ServiceTypeCapabilities selectGenByid(String serviceType,String iotCode);

    List<Properties> selectGenPro(int typeid);

}
