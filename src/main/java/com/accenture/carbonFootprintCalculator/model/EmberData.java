package com.accenture.carbonFootprintCalculator.model;

import com.opencsv.bean.CsvBindByName;

public class EmberData {
    @CsvBindByName(column= "country_or_region")
    private String country;

    @CsvBindByName
    private int year;

    @CsvBindByName(column= "variable")
    private String typeOfEnergy;

    @CsvBindByName(column = "share_of_generation_pct")
    private Double generationPercent;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTypeOfEnergy() {
        return typeOfEnergy;
    }

    public void setTypeOfEnergy(String typeOfEnergy) {
        this.typeOfEnergy = typeOfEnergy;
    }

    public Double getGenerationPercent() {
        return generationPercent;
    }

    public void setGenerationPercent(Double generationPercent) {
        this.generationPercent = generationPercent;
    }

    @Override
    public String toString() {
        return "EmberData{" +
                "country='" + country + '\'' +
                ", year=" + year +
                ", typeOfEnergy='" + typeOfEnergy + '\'' +
                ", generationPercent=" + generationPercent +
                '}';
    }


}
