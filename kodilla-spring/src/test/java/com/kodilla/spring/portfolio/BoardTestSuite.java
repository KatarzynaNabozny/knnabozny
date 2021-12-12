package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);

        List<String> toDoList = board.getToDoList().getTasks();
        List<String> inProgressList = board.getInProgressList().getTasks();
        List<String> doneList = board.getDoneList().getTasks();
        toDoList.add("todo1");
        inProgressList.add("inProgress1");
        doneList.add("done1");
        //When
        String actualToDo = toDoList.get(0);
        String actualInProgress = inProgressList.get(0);
        String actualDone = doneList.get(0);
        //Then
        assertEquals("todo1", actualToDo);
        assertEquals("inProgress1", actualInProgress);
        assertEquals("done1", actualDone);
    }

}
