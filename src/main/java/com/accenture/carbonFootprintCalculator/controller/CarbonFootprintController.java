package com.accenture.carbonFootprintCalculator.controller;

import com.accenture.carbonFootprintCalculator.model.InputFactors;
import com.accenture.carbonFootprintCalculator.model.OutputMetrics;
import com.accenture.carbonFootprintCalculator.service.CarbonFootprintService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

@RestController
@RequestMapping(value = "/carbonFootprint")
public class CarbonFootprintController {

    @Autowired
    CarbonFootprintService carbonFootprintService;

    @Value("${boavizta.url}")
    private String boaviztaUri;

    private List<InputFactors> output;

    @GetMapping(value = "/calculator")
    public String calculateFootprint() throws IOException {

        URL boaviztaUrl = new URL(boaviztaUri);
        InputStream in = boaviztaUrl.openStream();

        output = new CsvToBeanBuilder(new InputStreamReader(in))
                .withType(InputFactors.class)
                .withSeparator(',')
                .build()
                .parse();

        String outputJson = null;
        List<OutputMetrics> outputMetrics = new ArrayList<>();
        for (InputFactors inputFactors : output) {

            OutputMetrics outputMetric = carbonFootprintService.calculateMetrics(inputFactors);
            outputMetrics.add(outputMetric);

        }

        outputJson = new ObjectMapper().writeValueAsString(outputMetrics);
        return outputJson;
    }

    /*
        Method to get data based on model, make and number of devices
    */
    @PostMapping(value = "/calculatePerDevice/{numberOfDevice}")
    public String calculatePerDevice(@PathVariable("numberOfDevice") Optional<Integer> number, @RequestBody InputFactors deviceInfo) throws IOException {

        URL boaviztaUrl = new URL(boaviztaUri);
        InputStream in = boaviztaUrl.openStream();
        String outputJson = "";
        output = new CsvToBeanBuilder(new InputStreamReader(in))
                .withType(InputFactors.class)
                .withSeparator(',')
                .build()
                .parse();

        //System.out.println("*****************deviceInfo make: "+deviceInfo.getMake());
        //System.out.println("*****************deviceInfo model: "+deviceInfo.getModel());
        List<OutputMetrics> updatedMetrics = carbonFootprintService.calculateMetricsByFields(output,deviceInfo,number);
        outputJson = new ObjectMapper().writeValueAsString(updatedMetrics);

        return outputJson;
    }



}
