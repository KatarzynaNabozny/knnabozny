package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class TaskListDaoTestSuite {

    private static final String DESCRIPTION = "Test: Learn Hibernate";
    @Autowired
    private TaskListDao taskListDao;
    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList ("ToDo","Description");

        //When
        taskListDao.save(taskList);

        //Then
        int id = taskList.getId();
        Optional<TaskList> readTaskList = taskListDao.findByListName("ToDo");
        assertTrue(readTaskList.isPresent());

        //CleanUp
        taskListDao.deleteById(readTaskList.get().getId());
    }
    @Test
    void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList("listname", "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        //When
        taskListDao.save(taskList);
        int id = taskList.getId();

        //Then
        assertNotEquals(0, id);

        //CleanUp
        taskListDao.deleteById(id);

}}
