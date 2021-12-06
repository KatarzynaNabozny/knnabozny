package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            secondChallenge.probablyIWillThrowException(2, 8);
        } catch (Exception e) {
            System.out.println("Oh no! Something went wrong! Error:" + e);
            ;
        } finally {
            System.out.println("I am gonna be here... always!");
        }
    }

    @Test
    public void probablyIWillThrowException() {
        // given
        SecondChallenge  secondChallenge= new SecondChallenge();
        // when & then
        assertAll(
                () -> assertThrows(Exception.class, () ->secondChallenge.probablyIWillThrowException(2,5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1,1.5)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(0.5,1.5))
        );
    }
}
