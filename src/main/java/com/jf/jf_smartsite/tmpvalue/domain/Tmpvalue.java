package com.jf.jf_smartsite.tmpvalue.domain;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "run_tmpvalue")
public class Tmpvalue {
    private int id;
    private int stationid;
    private int deviceid;
    private int devicetypeid;
    private int channelid;
    private String value;
    private String clock;


}
