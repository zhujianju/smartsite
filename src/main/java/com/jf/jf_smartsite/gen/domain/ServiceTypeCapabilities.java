package com.jf.jf_smartsite.gen.domain;

import java.util.List;

public class ServiceTypeCapabilities {
    private String serviceId;
    private String serviceType;
    private String commands ="123";
    private String deviceTypeId;
    private List<Properties> propertiesList;

    @Override
    public String toString() {
        return "ServiceTypeCapabilities{" +
                "serviceId='" + serviceId + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", commands='" + commands + '\'' +
                ", propertiesList=" + propertiesList +
                '}';
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

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

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public List<Properties> getPropertiesList() {
        return propertiesList;
    }

    public void setPropertiesList(List<Properties> propertiesList) {
        this.propertiesList = propertiesList;
    }
}
