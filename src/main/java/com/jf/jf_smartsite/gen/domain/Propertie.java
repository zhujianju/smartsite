package com.jf.jf_smartsite.gen.domain;

public class Propertie {
    private String propertyName;
    private String dataType;
    private boolean required;
    private String min;
    private String max;
    private double step;
    private String method;
    private String unit;
    private long maxLength;
    private Integer enumList;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public void setMax(String max) {
        this.max = max;
    }


    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }


    public long getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(long maxLength) {
        this.maxLength = maxLength;
    }

    public String getMin() {
        return min;
    }

    public String getMax() {
        return max;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getEnumList() {
        return enumList;
    }

    public void setEnumList(Integer enumList) {
        this.enumList = enumList;
    }
}
