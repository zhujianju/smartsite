package com.jf.jf_smartsite.tmpvalue.domain;

import lombok.Data;

@Data
public class Tmpvalue {
    private int Id;
    private String StationId;
    private String DeviceId;
    private String DeviceTypeId;
    private String ChannelId;
    private String Value;
    private String Clock;
}
