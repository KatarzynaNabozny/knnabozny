package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {
    //    private static Map<String, Double> temperaturesMap = new HashMap<>();
    private static Map<String, Double> temperaturesMap;


    @Mock
    private static Temperatures temperaturesMock;


    @BeforeEach
    public void SetUp() {
        System.out.println("----Setting up data-----");
        temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszów", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
    }

    @Test
    void testCalculateForecastWithMock() {
        //Given
        // when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();
        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    void averageTemperaturesWithMock() {
        //Given
        //when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        double expAvgTemp = 25.56;
        //When
        double result = weatherForecast.averageTemperatures();
        //Then
        Assertions.assertEquals(expAvgTemp, result);
    }

    @Test
    void medianTemperaturesWithMock() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        double expMedianTemperature = 25.5;
        //When
        double result = weatherForecast.medianTemperatures();
        //Then
        Assertions.assertEquals(expMedianTemperature, result);
    }

}

