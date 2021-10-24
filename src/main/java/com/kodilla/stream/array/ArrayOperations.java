package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers) {
        IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .forEach(System.out::println);

        double average =
                IntStream.range(0, numbers.length)
                        .map(n -> numbers[n])
                        .average()
                        .getAsDouble();
        System.out.println(average);
        return average;

    }
}

         // int numberOfBooksPublicatedAfter2007 = IntStream.range(0, books.size())
        //average()
        //Metoda getAverage(int[] numbers) powinna:
        //przy pomocy strumienia IntStream oraz metody range(int startInclusive, int endExclusive) wyświetlić
        // kolejne elementy tablicy, a następnie:
        //przy pomocy drugiego strumienia IntStream oraz metody range(int startInclusive, int endExclusive),
        // a także kolektora average() obliczyć średnią.
        // Na końcu metoda powinna zwracać średnią jako wynik typu double.


