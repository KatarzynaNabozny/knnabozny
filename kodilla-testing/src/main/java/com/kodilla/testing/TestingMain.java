package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Moduł 6. Wprowadzenie to testowania oprogramowania");
        Calculator calculator = new Calculator();
        int result1 = calculator.add(1,2);
        if (result1 ==3) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
        int result2 = calculator.substract(2,2);
        if (result2==4) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
    }
}