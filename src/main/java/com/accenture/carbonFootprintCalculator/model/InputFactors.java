package com.accenture.carbonFootprintCalculator.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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


}
