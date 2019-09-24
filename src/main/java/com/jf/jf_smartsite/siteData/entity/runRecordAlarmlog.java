package com.jf.jf_smartsite.siteData.entity;

import lombok.Data;

import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 报警数据实体类
 */
@Data
@Table(name = "run_record_alarmlog")
public class runRecordAlarmlog {
    private Integer id;
    /**
     *站点编号
     */
    private Integer stationid;
    /**
     * 站点名称
     */
    @Transient
    private String stname;
    /**
     *设备编号
     */
    private Integer deviceid;
    /**
     * 设备名称
     */
    @Transient
    private String devname;
    /**
     *设备类型编号
     */
    private Integer devicetypeid;
    /**
     *设备类型名称
     */
    @Transient
    private String devtypname;
    /**
     *通道编号
     */
    private Integer channelid;
    /**
     *通道名称
     */
    @Transient
    private Integer channame;
    /**
     *告警时间
     */
    private String alarmclock;
    /**
     *告警内容
     */
    private String alarmtext;
    /**
     *告警值
     */
    private String alarmvalue;
    /**
     *抓拍图片绝对路径
     */
    private String imagepath;
    /**
     *告警事件名
     */
    private String eventname;
}
