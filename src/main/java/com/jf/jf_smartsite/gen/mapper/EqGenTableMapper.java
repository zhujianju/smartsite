package com.jf.jf_smartsite.gen.mapper;


import com.jf.jf_smartsite.gen.domain.Devices;
import com.jf.jf_smartsite.gen.domain.Properties;
import com.jf.jf_smartsite.gen.domain.ServiceTypeCapabilitie;
import com.jf.jf_smartsite.gen.domain.ServiceTypeCapabilities;
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

    ServiceTypeCapabilities selectGenByid(String serviceType);

    List<Properties> selectGenPro(String deviceTypeId);

}
