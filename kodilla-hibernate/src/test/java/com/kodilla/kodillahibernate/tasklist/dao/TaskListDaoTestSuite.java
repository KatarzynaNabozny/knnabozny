package com.kodilla.kodillahibernate.tasklist.dao;

import com.kodilla.kodillahibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class TaskListDaoTestSuite {

    private static final String DESCRIPTION = "Test: Learn Hibernate";
    @Autowired
    private TaskListDao taskListDao;
    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(2,"ToDo","Description");

        //When
        taskListDao.save(taskList);

        //Then
        int id = taskList.getId();
        Optional<TaskList> readTaskList = taskListDao.findByListName("ToDo");
        assertTrue(readTaskList.isPresent());

        //CleanUp
        taskListDao.deleteById(readTaskList.get().getId());
    }
}
