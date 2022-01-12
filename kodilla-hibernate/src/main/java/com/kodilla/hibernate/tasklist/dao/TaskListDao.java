package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.TaskList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Transactional
@Repository
public interface TaskListDao extends CrudRepository<TaskList,Integer> {
    Optional<TaskList> findByListName(String listName);
}
