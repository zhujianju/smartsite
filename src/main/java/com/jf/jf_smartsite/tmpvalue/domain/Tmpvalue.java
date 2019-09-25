package com.jf.jf_smartsite.tmpvalue.domain;

import lombok.Data;

@Data
public class Tmpvalue {
    private int id;
    private int deviceName; //设备名称
    private int deviceType; //设备类型
    private int deviceId;//设备编号
    private int channelName;  //报警类型
    private String value; //实际值
    private String alarm; //报警值
    private String clock; //采集时间

}
