package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test                                                 // [6]
    public void testBasicPizzaOrderGetCost() {             // [7]
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();         // [8]
        // When
        BigDecimal calculatedCost = theOrder.getCost();    // [9]
        // Then
        assertEquals(new BigDecimal(15), calculatedCost);   // [10]
    }                                                     // [11]

    @Test                                                 // [12]
    public void testBasicPizzaOrderGetDescription() {      // [13]
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();         // [14]
        // When
        String description = theOrder.getDescription();    // [15]
        // Then
        assertEquals("Margherita", description);       // [16]
    }

    @Test
    public void testExtraCheeseGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheeseDecorator(theOrder);
        System.out.println(theOrder.getCost());
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(17), theCost);
    }

    @Test
    public void testExtraSauceGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraSauceDecorator(theOrder);
        System.out.println(theOrder.getCost());
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(17), theCost);
    }

    @Test
    public void testPizzaToppingsGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new PizzaToppingsDecorator(theOrder);
        System.out.println(theOrder.getCost());
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(17), theCost);
    }

    @Test
    public void testBasicPizzaWithToppingsWithExtraCheeseWithExtraSauceGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new PizzaToppingsDecorator(theOrder);
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new ExtraSauceDecorator(theOrder);
        System.out.println(theOrder.getCost());
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(21), theCost);
    }

    @Test
    public void testBasicPizzaWithToppingsWithExtraCheeseWithExtraSauceGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new PizzaToppingsDecorator(theOrder);
        theOrder = new ExtraCheeseDecorator(theOrder);
        theOrder = new ExtraSauceDecorator(theOrder);
        System.out.println(theOrder.getDescription());
        //When
        String Description = theOrder.getDescription();
        //Then
        assertEquals("Margherita + extra toppings + extra cheese + extra sauce", Description);
    }


}


