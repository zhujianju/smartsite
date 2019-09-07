package com.jf.jf_smartsite.gen.domain;

import java.util.List;

public class ServiceTypeCapabilities {
    private String serviceId;
    private String serviceType;
    private String option;
    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "ServiceTypeCapabilities{" +
                "serviceId='" + serviceId + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", option='" + option + '\'' +
                '}';
    }
}
