package com.accenture.carbonFootprintCalculator.model;

public class OutputMetrics {

    private String make;
    private Float usagePerYear;
    private Float manufacturingPerYear;
    private Float transportPerYear;
    private Float totalEmissionPerYear;

    public OutputMetrics(String make, Float usagePerYear, Float manufacturingPerYear, Float transportPerYear, Float totalEmissionPerYear) {
        this.make = make;
        this.usagePerYear = usagePerYear;
        this.manufacturingPerYear = manufacturingPerYear;
        this.transportPerYear = transportPerYear;
        this.totalEmissionPerYear = totalEmissionPerYear;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Float getUsagePerYear() {
        return usagePerYear;
    }

    public void setUsagePerYear(Float usagePerYear) {
        this.usagePerYear = usagePerYear;
    }

    public Float getManufacturingPerYear() {
        return manufacturingPerYear;
    }

    public void setManufacturingPerYear(Float manufacturingPerYear) {
        this.manufacturingPerYear = manufacturingPerYear;
    }

    public Float getTransportPerYear() {
        return transportPerYear;
    }

    public void setTransportPerYear(Float transportPerYear) {
        this.transportPerYear = transportPerYear;
    }

    public Float getTotalEmissionPerYear() {
        return totalEmissionPerYear;
    }

    public void setTotalEmissionPerYear(Float totalEmissionPerYear) {
        this.totalEmissionPerYear = totalEmissionPerYear;
    }
}
