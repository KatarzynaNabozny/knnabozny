package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {
    @Test
    void testGetPeopleQuantity(){
        //given
        Country poland = new Country(new BigDecimal("38000000"));
        Country germany = new Country(new BigDecimal("60000000"));
        Country espania = new Country(new BigDecimal("55000000"));
        List<Country> countries = new ArrayList<>();
        countries.add(poland);
        countries.add(germany);
        countries.add(espania);
        Continent europe = new Continent(countries);
        List<Continent> continents = new ArrayList<>();
        continents.add(europe);
        World world = new World(continents);
        //when
       BigDecimal peopleQuantity = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPeopleQuantity = new BigDecimal("153000000");
        assertEquals(expectedPeopleQuantity, peopleQuantity);
    }
}
    //Napisz test testGetPeopleQuantity(),
    // który przetestuje czy metoda getPeopleQuantity() klasy World
    // działa prawidłowo.
