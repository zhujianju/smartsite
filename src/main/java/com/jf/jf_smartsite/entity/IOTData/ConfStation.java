package com.jf.jf_smartsite.entity.IOTData;



import lombok.Data;

import java.io.Serializable;

/**
 * 站点对象 conf_station
 * 
 * @author 欧阳兴
 * @date 2019-09-04
 */
@Data
public class ConfStation implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String province;
    private String city;
    private String address;
    private String iotdevid;
    private String iotnodeid;
    private String iotverifycode;
    private Long iottypeid;


}
