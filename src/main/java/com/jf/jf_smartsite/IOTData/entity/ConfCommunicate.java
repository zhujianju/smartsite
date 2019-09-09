package com.jf.jf_smartsite.IOTData.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 通讯模式对象 conf_communicate
 * 
 * @author ruoyi
 * @date 2019-09-05
 */
@Data
public class ConfCommunicate implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 通讯模式编号 */
    private Integer id;

    /** 通讯类型 */
    private Integer type;

    /** 通讯模式名称 */
    private String name;

    /** 参数 */
    private String param;

    /** 间隔时间（单位：秒） */
    private Long intervals;

    /** 启用标识 */
    private Integer enalbe;


}
