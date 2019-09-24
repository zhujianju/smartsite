package com.jf.jf_smartsite.IOTData.mapper;

import com.jf.jf_smartsite.IOTData.entity.ConfDevice;
import com.jf.jf_smartsite.IOTData.entity.comEntity.ConfDeviceDTypeDCom;
import tk.mybatis.mapper.common.Mapper;

/**
 * 设备对象的Mapper
 */
public interface ConfDeviceMapper extends Mapper<ConfDevice> {

    /**
     * 测试后mapper文件sql是否能调用
     * @param deviceId
     * @return
     */
    ConfDevice selectFromId(Integer deviceId);
}
