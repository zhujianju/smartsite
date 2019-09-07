package com.jf.jf_smartsite.IOTData.server;

import com.jf.jf_smartsite.IOTData.entity.ConfStation;

import java.util.List;

public interface ConfStationService extends ComService<ConfStation>{
        /**
         * 根据iotID查询出所有站点
         * @param iotId
         * @return
         */
        public List<ConfStation> findStationByIOTid(Integer iotId);
}
