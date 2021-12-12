package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Bean(name = "toDo")
    public TaskList toDoList() {
        TaskList taskList = new TaskList();
        return taskList;
    }

    @Bean(name = "inProgress")
    public TaskList inProgressList() {
        TaskList taskList = new TaskList();
        return taskList;
    }

    @Bean(name = "done")
    public TaskList doneList() {
        TaskList taskList = new TaskList();
        return taskList;
    }

    @Bean
    public Board getBoard() {
        return new Board();
    }
}
