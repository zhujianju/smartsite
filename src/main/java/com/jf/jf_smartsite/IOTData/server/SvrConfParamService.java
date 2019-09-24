package com.jf.jf_smartsite.IOTData.server;

import com.jf.jf_smartsite.IOTData.entity.SvrConfParam;

public interface SvrConfParamService extends ComService<SvrConfParam> {

    /**
     * 主键id为key的，单体查询
     * @param key
     * @return
     */
    public SvrConfParam findOne(String key);

    /**
     * 主键id为key的，单体删除
     * @param key
     * @return
     */
    public int deleteById(String key);

}
