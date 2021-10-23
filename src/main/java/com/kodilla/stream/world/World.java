package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World {
    List<Continent> continents = new ArrayList<>();

    public World(List<Continent> continents) {
        this.continents = continents;
    }

    public void addContinent(Continent continent) {
        continents.add(continent);
    }

    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleQuantity = continents.stream()
                .flatMap( continent -> continent.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

        return peopleQuantity;
    }
}
//Klasa World powinna zawierać kolekcję kontynentów.
//W klasie World napisz metodę getPeopleQuantity() zwracającą liczbę typu BigDecimal,
// która używając flatMap() oraz reduce() obliczy sumę ludności wszystkich krajów
// na wszystkich kontynentach