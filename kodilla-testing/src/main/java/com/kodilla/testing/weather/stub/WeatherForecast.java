package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;
    private Set<Map.Entry<String, Double>> entries;

    public WeatherForecast(Temperatures temperatures) {

        this.temperatures = temperatures;
    }

    public Map<String,Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double averageTemperatures() {
        double result = 0;

        entries = temperatures.getTemperatures().entrySet();
        for (Map.Entry<String, Double> temperature : entries) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            result += temperature.getValue();
        }

        return result/entries.size();
    }

    public double medianTemperatures(){
        List<Double> temperatureValues = new ArrayList<>(temperatures.getTemperatures().values());
        Collections.sort(temperatureValues);
            int middle = temperatureValues.size() / 2;
            middle = middle > 0 && middle % 2 == 0 ? middle - 1 : middle;
            return temperatureValues.get(middle);
        }

    }

