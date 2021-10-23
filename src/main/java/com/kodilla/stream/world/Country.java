package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Country {
   private BigDecimal peopleQuantity;

    public BigDecimal getPeopleQuantity() {
        return peopleQuantity;
    }

    public Country(BigDecimal peopleQuantity) {
        this.peopleQuantity = peopleQuantity;
    }
    //Klasa Country ma udostępniać metodę getPeopleQuantity() zwracającą liczbę typu BigDecimal.
}
