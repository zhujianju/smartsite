package com.jf.jf_smartsite.gen.domain;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
public class ServiceTypeCapabilities {
    private String serviceType;
    private List<Object> commands = new ArrayList<>();
    private String description;
    @JSONField(serialize = false)
    private String typeId;
    private List<Propertie> properties;

    @Override
    public String toString() {
        return "ServiceTypeCapabilities{" +
                "serviceType='" + serviceType + '\'' +
                ", commands=" + commands +
                ", description='" + description + '\'' +
                ", typeId='" + typeId + '\'' +
                ", properties=" + properties +
                '}';
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public List<Object> getCommands() {
        return commands;
    }

    public void setCommands(List<Object> commands) {
        this.commands = commands;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Propertie> getProperties() {
        return properties;
    }

    public void setProperties(List<Propertie> properties) {
        this.properties = properties;
    }
}
