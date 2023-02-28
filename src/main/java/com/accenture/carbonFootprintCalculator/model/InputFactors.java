package com.accenture.carbonFootprintCalculator.model;

import com.opencsv.bean.CsvBindByName;

public class InputFactors {

    @CsvBindByName(column = "MANUFACTURER")
    private String model;

    @CsvBindByName(column = "NAME")
    private String make;

    @CsvBindByName(column = "SUBCATEGORY")
    private String deviceType;

    @CsvBindByName(column = "LOCATION",required = false)
    private String manufacturedIn;

    @CsvBindByName(column = "GWP_TOTAL")
    private float gwpTotal;
    @CsvBindByName(column = "GWP_USE_RATIO")
    private float gwpUseRatio;

    @CsvBindByName(column = "GWP_TRANSPORT_RATIO")
    private float gwpTransportRatio;

    @CsvBindByName(column = "GWP_MANUFACTURING_RATIO")
    private float gwpManufacturingRatio;

    @CsvBindByName(column = "LIFETIME")
    private String lifetime;

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getManufacturedIn() {
        return manufacturedIn;
    }

    public void setManufacturedIn(String manufacturedIn) {
        this.manufacturedIn = manufacturedIn;
    }

    public float getGwpUseRatio() {
        return gwpUseRatio;
    }

    public void setGwpUseRatio(float gwpUseRatio) {
        this.gwpUseRatio = gwpUseRatio;
    }

    public float getGwpTransportRatio() {
        return gwpTransportRatio;
    }

    public void setGwpTransportRatio(float gwpTransportRatio) {
        this.gwpTransportRatio = gwpTransportRatio;
    }

    public float getGwpManufacturingRatio() {
        return gwpManufacturingRatio;
    }

    public void setGwpManufacturingRatio(float gwpManufacturingRatio) {
        this.gwpManufacturingRatio = gwpManufacturingRatio;
    }

    public String getLifetime() {
        return lifetime;
    }

    public void setLifetime(String lifetime) {
        this.lifetime = lifetime;
    }

    public float getGwpTotal() {
        return gwpTotal;
    }

    public void setGwpTotal(float gwpTotal) {
        this.gwpTotal = gwpTotal;
    }

}
