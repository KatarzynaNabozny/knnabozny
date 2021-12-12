package com.kodilla.testing.statistic;

import java.util.List;

public interface Statistics {
    List<String> usersNames(); // list of users names
    int postsCount();          // total quantity of com.kodilla.spring.forum posts
    int commentsCount();       // total quantity of com.kodilla.spring.forum comments
}
