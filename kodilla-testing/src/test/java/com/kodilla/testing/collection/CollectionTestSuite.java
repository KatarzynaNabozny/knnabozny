package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionTestSuite {

    @BeforeEach
    void before(){
        System.out.println("Checking exterminate method from OddNumbersExterminator");
    }

    @AfterEach
    void after(){
        System.out.println("End of checking");
    }

    @DisplayName("Checks if result list is empty")
    @Test
    void testOddNumbersExterminatorEmptyList(){
        //given
        List<Integer> emptyNumberList = new ArrayList<>();
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //when
        List<Integer> result = oddNumbersExterminator.exterminate(emptyNumberList);
        //then
        Assertions.assertEquals(emptyNumberList, result);
    }

    @DisplayName("Checks if result list have only odd numbers")
    @Test
    void testOddNumbersExterminatorNormalList() {
        // given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        Integer expectedFirstElement = 2;
        //when
        List<Integer> result = oddNumbersExterminator.exterminate(numbers);
        // then
        Assertions.assertEquals(expectedFirstElement, result.get(0));
    }

    @DisplayName("Checks if result list have only odd numbers with Arrays")
    @Test
    void testOddNumbersExterminatorNormalListWithArrays() {
        // given
        List<Integer> numbers = Arrays.asList(1,2,3,4);

        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        Integer expectedFirstElement = 2;
        //when
        List<Integer> result = oddNumbersExterminator.exterminate(numbers);
        // then
        Assertions.assertEquals(expectedFirstElement, result.get(0));
    }
}