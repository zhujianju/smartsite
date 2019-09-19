package com.jf.jf_smartsite.gen.domain;

import java.util.List;

public class Devices {
    private String manufacturerId;
    private String manufacturerName;
    private String model;
    private String protocolType;
    private String deviceType;
    private List<ServiceTypeCapabilitie> serviceTypeCapabilities;

    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public List<ServiceTypeCapabilitie> getServiceTypeCapabilities() {
        return serviceTypeCapabilities;
    }

    public void setServiceTypeCapabilities(List<ServiceTypeCapabilitie> serviceTypeCapabilities) {
        this.serviceTypeCapabilities = serviceTypeCapabilities;
    }

    @Override
    public String toString() {
        return "Devices{" +
                "manufacturerId='" + manufacturerId + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", model='" + model + '\'' +
                ", protocolType='" + protocolType + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", serviceTypeCapabilities=" + serviceTypeCapabilities +
                '}';
    }
}
