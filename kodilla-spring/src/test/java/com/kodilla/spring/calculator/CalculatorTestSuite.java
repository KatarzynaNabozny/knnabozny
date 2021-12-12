package com.kodilla.spring.calculator;

import com.kodilla.spring.forum.ForumUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double addResult = calculator.add(4, 4);
        double subResult = calculator.sub(4, 4);
        double divResult = calculator.div(4, 4);
        double mulResult = calculator.mul(4, 4);

        //Then
        assertEquals(8, addResult);
        assertEquals(0, subResult);
        assertEquals(1, divResult);
        assertEquals(16, mulResult);

    }
}
