package com.jf.jf_smartsite.IOTData.server;

import com.jf.jf_smartsite.IOTData.entity.ConfDevice;
import com.jf.jf_smartsite.IOTData.entity.comEntity.ConfDeviceDTypeDCom;
import com.jf.jf_smartsite.IOTData.entity.comEntity.PageResult;

import java.util.List;


public interface ConfDeviceService extends ComService<ConfDevice>{

    /**
     * 根据站点id,查询所有设备
     * @param id
     * @return
     */
    public List<ConfDeviceDTypeDCom> findDeviceByStationId(Integer id);

    /**
     * 测试类方法
     * @param deviceId
     */
    public void selectFromId(Integer deviceId);

}
