package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.statistic.CalculatorForStatistics;
import com.kodilla.testing.statistic.Statistics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculatorForStatisticsTest {

    private List<String> userList;

    @BeforeEach
    void setUp() {
        userList = new ArrayList<>();
        for (int i=1; i<=100; i++) {
            userList.add("User " + i);
        }
    }

    @Mock
    Statistics statisticsMock;

    @Test
    void calculateAdvStatisticsNumberOfZeroComments() {
        //gives
        CalculatorForStatistics calculatorForStatistics = new CalculatorForStatistics();
        Integer commentsCount = 0;
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        //when
        calculatorForStatistics.calculateAdvStatistics(statisticsMock);
        //then
        Assertions.assertEquals(0, calculatorForStatistics.getNumberOfComments());
    }
    @Test
    void calculateAdvStatisticsNumberOfThousandComments() {
        //gives
        CalculatorForStatistics calculatorForStatistics = new CalculatorForStatistics();
        Integer commentsCount = 1000;
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        //when
        calculatorForStatistics.calculateAdvStatistics(statisticsMock);
        //then
        Assertions.assertEquals(1000, calculatorForStatistics.getNumberOfComments());
    }
    @Test
    void calculateAdvStatisticsNumberOfZeroPosts() {
        //gives
        CalculatorForStatistics calculatorForStatistics = new CalculatorForStatistics();
        Integer postCount = 0;
        when(statisticsMock.postsCount()).thenReturn(postCount);
        //when
        calculatorForStatistics.calculateAdvStatistics(statisticsMock);
        //then
        Assertions.assertEquals(0, calculatorForStatistics.getNumberOfPosts());
    }
    @Test
    void calculateAdvStatisticsNumberOfThousandPosts() {
        //gives
        CalculatorForStatistics calculatorForStatistics = new CalculatorForStatistics();
        Integer postCount = 1000;
        when(statisticsMock.postsCount()).thenReturn(postCount);
        //when
        calculatorForStatistics.calculateAdvStatistics(statisticsMock);
        //then
        Assertions.assertEquals(1000, calculatorForStatistics.getNumberOfPosts());
    }
    @Test
    void calculateAdvStatisticsWhenNumberOfPostsIsSmallerThenNumberOfComments() {
        //gives
        CalculatorForStatistics calculatorForStatistics = new CalculatorForStatistics();
        Integer commentsCount = 1000;
        Integer postCount = 100;
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        //when
        calculatorForStatistics.calculateAdvStatistics(statisticsMock);
        //then
        Assertions.assertEquals(10, calculatorForStatistics.getAvgCommentsForPost());
    }
    @Test
    void calculateAdvStatisticsWhenNumberOfCommentsIsSmallerThenNumberOfPosts() {
        //gives
        CalculatorForStatistics calculatorForStatistics = new CalculatorForStatistics();
        int commentsCount = 100;
        int postCount = 1000;
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        //when
        calculatorForStatistics.calculateAdvStatistics(statisticsMock);
        //then
        Assertions.assertEquals(0.1, calculatorForStatistics.getAvgCommentsForPost());
    }
    @Test
    void calculateAdvStatisticsWhenUserNumberIsZero() {
        //gives
        CalculatorForStatistics calculatorForStatistics = new CalculatorForStatistics();
        List<String> userList = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(userList);
        //when
        calculatorForStatistics.calculateAdvStatistics(statisticsMock);
        //then
        Assertions.assertEquals(0, calculatorForStatistics.getNumberOfUser());
    }
    @Test
    void calculateAdvStatisticsWhenUserNumberIsHundred() {
        //gives
        CalculatorForStatistics calculatorForStatistics = new CalculatorForStatistics();
        when(statisticsMock.usersNames()).thenReturn(userList);
        //when
        calculatorForStatistics.calculateAdvStatistics(statisticsMock);
        //then
        Assertions.assertEquals(100, calculatorForStatistics.getNumberOfUser());
    }
}