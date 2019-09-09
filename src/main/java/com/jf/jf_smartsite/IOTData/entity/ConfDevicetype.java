package com.jf.jf_smartsite.IOTData.entity;

import lombok.Data;


import java.io.Serializable;

/**
 * 设备类型(服务类型)对象 conf_devicetype
 * 
 * @author ruoyi
 * @date 2019-09-05
 */
@Data
public class ConfDevicetype implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 类型编号 */
    private Long id;

    /** 类型名 */
    private String name;

    /** 类型识别码 */
    private String typecode;

    /** 指令发送时间间隔，（单位：毫秒） */
    private Long intervals;

    /** 厂家 */
    private String company;


}
