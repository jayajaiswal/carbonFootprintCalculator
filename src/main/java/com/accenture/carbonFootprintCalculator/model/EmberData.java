package com.accenture.carbonFootprintCalculator.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmberData {
    @CsvBindByName(column= "country_or_region")
    private String country;

    @CsvBindByName
    private int year;

    @CsvBindByName(column= "variable")
    private String typeOfEnergy;

    @CsvBindByName(column = "share_of_generation_pct")
    private Double generationPercent;

    @CsvBindByName(column = "percent_energy")
    private double percentEnergy;


    @Override
    public String toString() {
        return "EmberData{" +
                "country='" + country + '\'' +
                ", year=" + year +
                ", typeOfEnergy='" + typeOfEnergy + '\'' +
                ", generationPercent=" + generationPercent +
                ", percentEnergy=" + percentEnergy +
                '}';
    }
}
