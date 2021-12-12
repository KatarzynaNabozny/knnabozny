package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Board {

    @Autowired
    @Qualifier("toDo")
    private TaskList toDoList;
    @Autowired
    @Qualifier("inProgress")
    private TaskList inProgressList;
    @Autowired
    @Qualifier("done")
    private TaskList doneList;

    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }
}
