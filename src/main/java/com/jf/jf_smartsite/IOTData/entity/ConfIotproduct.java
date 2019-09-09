package com.jf.jf_smartsite.IOTData.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ConfIotproduct implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** null */

    private Long id;

    /** 厂商Id Iot */

    private String firmid;

    /** 厂商名称 */

    private String firmname;

    /** 产品名称 */

    private String productname;

    /** 产品Id */

    private String productid;

    /** 产品协议类型,MQTT ,CoAP */

    private String protocol;

    /** 产品类型 */

    private String type;

    /** 型号 */

    private String typeno;


}