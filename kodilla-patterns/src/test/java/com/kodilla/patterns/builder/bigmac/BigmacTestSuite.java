package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {
    @Test
    void testBigmacNew() {
        //given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("Sesame")
                .burgers("Two")
                .sauce("Standard")
                .ingredient("Onion")
                .ingredient("Mushrooms")
                .ingredient("Ham")
                .build();
        System.out.println(bigmac);
        //when
        int howManyIngredients = bigmac.getIngredients().size();
        //then
        assertEquals(3, howManyIngredients);
    }
}
