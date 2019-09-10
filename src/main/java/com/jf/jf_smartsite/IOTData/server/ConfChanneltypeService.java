package com.jf.jf_smartsite.IOTData.server;

import com.jf.jf_smartsite.IOTData.entity.ConfChanneltype;

import java.util.List;

public interface ConfChanneltypeService extends  ComService<ConfChanneltype> {
    /**
     * 根据设备类型id查找所有的通道
     * @param id
     * @return
     */
    List<ConfChanneltype> findChannelTypeByDeviceId(Integer id);
}
