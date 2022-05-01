package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTaskTestSuite {

    @Test
    public void testUpdate() {
        // Given
        StudentTask hibernateTask = new MaciekKowalczykTask();
        StudentTask patternsTask = new MonikaKowalskiTask();
        Mentor johnSmith = new Mentor("John Smith");
        Mentor ivoneEscobar= new Mentor("Ivone Escobar");
        hibernateTask.registerObserver(johnSmith);
        patternsTask.registerObserver(ivoneEscobar);
       hibernateTask.registerObserver(ivoneEscobar);
        // When
        hibernateTask.addTask("15.5 task");
        hibernateTask.addTask("15.3 task");
        patternsTask.addTask("16.1 task");
        patternsTask.addTask("16.3");
        // Then
        assertEquals(2, johnSmith.getUpdateCount());
        assertEquals(4, ivoneEscobar.getUpdateCount());
    }
}

