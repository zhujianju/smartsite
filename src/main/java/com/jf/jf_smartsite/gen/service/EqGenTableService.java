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
     *  传入设备id,和项目的路径
     * @return 设备原型信息
     */
    public void selectGenTable(int id,String path) throws FileNotFoundException;


}
