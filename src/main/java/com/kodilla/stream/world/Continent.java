package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {
    private List<Country> countries = new ArrayList<>();

    public List<Country> getCountries() {
        return countries;
    }

    public Continent(List<Country> countries) {
        this.countries = countries;
    }

    public void addCountry(Country country) {
         countries.add(country);
    }

    //Klasa Continent powinna zawierać kolekcję krajów leżących na tym kontynencie
}
