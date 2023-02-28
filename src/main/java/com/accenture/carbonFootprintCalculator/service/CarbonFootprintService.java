package com.accenture.carbonFootprintCalculator.service;

import com.accenture.carbonFootprintCalculator.model.EmberData;
import com.accenture.carbonFootprintCalculator.model.InputFactors;
import com.accenture.carbonFootprintCalculator.model.OutputMetrics;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarbonFootprintService {

    @Value("${emberData.url}")
    private String emberDataUri;

    private static List<String> bioEnergy = Arrays.asList("Bioenergy", "Clean", "Hydro", "Other Renewables", "Solar", "Wind","Nuclear");

    public OutputMetrics calculateMetrics(InputFactors inputs){

        Float lifetime = 1.0f;
        if(!inputs.getLifetime().isEmpty()){
            lifetime = Float.valueOf(inputs.getLifetime());
        }


        // converting usage ratio into usage per year in kgCO2eq
        float usagePerYear = (inputs.getGwpTotal()*inputs.getGwpUseRatio())/lifetime;

        // converting manufacturing ratio into manufacturing per year in kgCO2eq
        float manufacturingPerYear = (inputs.getGwpTotal()*inputs.getGwpManufacturingRatio())/lifetime;

        // converting transport ratio into transport per year in kgCO2eq
        float transportPerYear = (inputs.getGwpTotal()*inputs.getGwpTransportRatio())/lifetime;

        OutputMetrics output = new OutputMetrics(inputs.getMake(), usagePerYear,manufacturingPerYear,transportPerYear,
                (usagePerYear+manufacturingPerYear+transportPerYear));

        return output;


    }

    public List<OutputMetrics> calculateMetricsByFields(List<InputFactors> output,InputFactors deviceInfo, Optional<Integer> number) throws IOException {

        List<InputFactors> filteredOutput;
        if(!deviceInfo.getManufacturedIn().isEmpty()){

           List<EmberData> emberData =  new CsvToBeanBuilder<EmberData>(new FileReader(emberDataUri))
                    .withType(EmberData.class)
                   .withSeparator(';')
                    .build()
                    .parse()
                   .stream()
                   .filter(data -> data.getYear() == 2021)
                   .collect(Collectors.toList());

           System.out.println("emberData: "+emberData.size());
           Double percentShareOfBioEnergy = emberData.stream()
                                            .filter( energy -> !bioEnergy.contains(energy.getTypeOfEnergy()))
                                            .map(data -> data.getGenerationPercent())
                                            .collect(Collectors.summingDouble(Double :: doubleValue));

           emberData.forEach(System.out::println);
           System.out.println("percent share: "+percentShareOfBioEnergy);

        }
        filteredOutput = output.stream().
                filter(input ->
                        (input.getModel().equals(deviceInfo.getModel()) && input.getMake().equals(deviceInfo.getMake()))
                ).
                collect(Collectors.toList());
        List<OutputMetrics> updatedMetrics = new ArrayList<>();
        String outputJson = "";
        System.out.println("filtered: " + filteredOutput.size());

        for (InputFactors inputFactors : filteredOutput) {
            OutputMetrics outputMetric = calculateMetrics(inputFactors);
            if (number.isPresent()) {
                outputMetric.setManufacturingPerYear(outputMetric.getManufacturingPerYear() * number.get());
                outputMetric.setTotalEmissionPerYear(outputMetric.getTotalEmissionPerYear() * number.get());
                outputMetric.setUsagePerYear(outputMetric.getUsagePerYear() * number.get());
                outputMetric.setTransportPerYear(outputMetric.getTransportPerYear() * number.get());

            }
            updatedMetrics.add(outputMetric);
        }
    return updatedMetrics;
    }
}
