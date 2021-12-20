package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskFactoryTestSuite {
    @Test
    void testShoppingTask() {
        //given
        TaskFactory factory =  new TaskFactory();
        //when
        Tasks shopping = factory.makeTasks(TaskFactory.SHOPPINGTASK);
        shopping.executeTask();
        //then
        Assertions.assertEquals("buying",shopping.getTaskName());
        Assertions.assertTrue(shopping.isTaskExecuted());
    }
    @Test
    void testPaintingTask() {
        //given
        TaskFactory factory = new TaskFactory();
        //when
        Tasks painting = factory.makeTasks(TaskFactory.PAINTINGTASK);
        painting.executeTask();
        //then
        Assertions.assertEquals("painting",painting.getTaskName());
        Assertions.assertTrue(painting.isTaskExecuted());
    }

    @Test
    void testDrivingTask() {
        //given
        TaskFactory factory = new TaskFactory();
        //when
        Tasks driving = factory.makeTasks(TaskFactory.DRIVINGTASK);
        driving.executeTask();
        //then
        Assertions.assertEquals("driving",driving.getTaskName());
        Assertions.assertTrue(driving.isTaskExecuted());
    }

}
