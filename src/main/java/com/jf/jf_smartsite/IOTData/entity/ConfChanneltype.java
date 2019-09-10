package com.jf.jf_smartsite.IOTData.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * 通道类型(服务属性)对象 conf_channeltype
 * 
 * @author ruoyi
 * @date 2019-09-05
 */
@Data
public class ConfChanneltype implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 索引编号 */
    private Long id;

    /** 设备类型编号 */
    private Long devicetypeid;

    /** 通道编号 */
    private Integer channelid;

    /** 通道类型 1 遥测 2 遥信 3 遥调 4 遥控 */
    private Integer channeltype;

    /** 通道名 */
    private String channelname;

    /** 数据类型 1float 2 int 3 字符串 */
    private Integer datatype;

    /** 通道识别码(属性名称) */
    private String iotchlcode;

    /** 单位 */
    private String unit;

    /** 最小值 */
    private Integer min;

    /** 最大值 */
    private Long max;

    /** 步长 暂不使用，填 0 即可  (忽略) */
    private String step;

    /** 指示本条属性是否必选（1 true 2fasle */
    private Integer required;

    /** 指示字符串长度     (忽略)*/
    private String maxlength;
    /*指示枚举*             (忽略)/
    private String enumlist;
    /*指示访问模式 R:可读；W:可写；E 可订阅 取值范围：R、RW、RE、RWE 、null (忽略) */
    private String method;
}
