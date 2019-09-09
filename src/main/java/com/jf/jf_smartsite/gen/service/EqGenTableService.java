package com.jf.jf_smartsite.gen.service;


import java.io.FileNotFoundException;

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
    public void selectGenTable(int id) throws FileNotFoundException;


}
