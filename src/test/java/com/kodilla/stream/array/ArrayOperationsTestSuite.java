package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayOperationsTestSuite {
    @Test
   void testGetAverage(){
        //given
        int[] number = new int[20];
        number[0] = 10;
        number[1] = 20;
        number[2] = 30;
        number[3] = 40;
        number[4] = 50;
        number[5] = 60;
        number[6] = 70;
        number[7] = 80;
        number[8] = 90;
        number[9] = 100;
        number[10] = 101;
        number[11] = 102;
        number[12] = 103;
        number[13] = 104;
        number[14] = 105;
        number[15] = 106;
        number[16] = 107;
        number[17] = 108;
        number[18] = 109;
        number[19] = 110;
        //when
         double actualAverage = ArrayOperations.getAverage(number);
        //then
         Assertions.assertEquals(80.25,actualAverage);
    }
//Test powinien przygotować tablicę z przykładowymi wartościami typu int
// i wywołać metodę getAverage(int[] numbers) interfejsu ArrayOperations.
//Przy pomocy asercji sprawdź, czy obliczona średnia jest poprawna.

    //Zadanie polega na obliczeniu średniej z liczb typu int zapisanych w tablicy składającej się z 20 elementów.
    // Użyj do tego dwóch pętli kolejno po sobie – pierwsza pętla powinna wyświetlić wszystkie liczby z tablicy,
    // a druga obliczyć średnią.
}
