package com.jf.jf_smartsite.gen.service;


import com.jf.jf_smartsite.gen.domain.Devices;

/**
 * 业务 服务层
 *
 * @author hz
 */
public interface EqGenTableService {

    /**
     * 查询设备原型信息
     *
     * @return 设备原型信息
     */
    public byte[] selectGenTable(int id) ;


}
