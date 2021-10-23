package com.kodilla.testing.statistic;

public class CalculatorForStatistics {
    int numberOfUser;
    int numberOfPosts;
    int numberOfComments;
    double avgPostsForUser;
    double avgCommentsForPost;
    double avgCommentsForUser;

    public void calculateAdvStatistics(Statistics statistics) {
        numberOfComments = statistics.commentsCount();
        numberOfPosts = statistics.postsCount();
        numberOfUser = statistics.usersNames().size();
        if (numberOfPosts != 0) {
            avgCommentsForPost = (double) numberOfComments / numberOfPosts;
        }
        if (numberOfUser != 0) {
            avgPostsForUser = (double) numberOfPosts / numberOfUser;
        }
        if (numberOfUser != 0) {
            avgCommentsForUser = (double) numberOfComments / numberOfUser;
        }
    }

    public int getNumberOfUser() {
        return numberOfUser;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public double getAvgPostsForUser() {
        return avgPostsForUser;
    }

    public double getAvgCommentsForPost() {
        return avgCommentsForPost;
    }

    public double getAvgCommentsForUser() {return avgCommentsForUser;}

    public void showStatistics() {
        System.out.println("CalculatorForStatistics{" +
                "numberOfUser=" + numberOfUser +
                ", numberOfPosts=" + numberOfPosts +
                ", numberOfComments=" + numberOfComments +
                ", avgPostsForUser=" + avgPostsForUser +
                ", avgCommentsForPost=" + avgCommentsForPost +
                ",avgCommentsForUser=" + avgCommentsForUser +
                '}');
    }
}
