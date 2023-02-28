package com.accenture.carbonFootprintCalculator.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}
