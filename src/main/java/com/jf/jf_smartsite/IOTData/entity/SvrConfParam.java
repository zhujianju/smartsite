package com.jf.jf_smartsite.IOTData.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class SvrConfParam implements Serializable {

    private String item; //参数项

    private  String keyz;//参数关键子

    private  String valuez;//值

    private String remask;//备注


}
