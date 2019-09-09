package com.jf.jf_smartsite.IOTData.entity.comEntity;

import com.jf.jf_smartsite.IOTData.entity.ConfCommunicate;
import com.jf.jf_smartsite.IOTData.entity.ConfDevice;
import com.jf.jf_smartsite.IOTData.entity.ConfDevicetype;
import lombok.Data;

import java.io.Serializable;

/**
 * 设备_设备类型_设备_通讯综合表
 */
@Data
public class ConfDeviceDTypeDCom implements Serializable {

    private ConfDevice confDevice;

    private ConfDevicetype confDevicetype;

    private ConfCommunicate confCommunicate;

    /**
     * 站点名称
     */
    private String stationName;

}
