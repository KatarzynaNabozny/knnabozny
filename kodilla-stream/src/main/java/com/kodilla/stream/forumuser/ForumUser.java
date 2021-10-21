package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Objects;

public  final class ForumUser {
    private final int uniqueUserID;
    private final String login;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int numberOfPosts;

    public ForumUser(final int uniqueUserID, final String login, final char sex,
                     final LocalDate dateOfBirth, final int numberOfPosts) {
        this.uniqueUserID = uniqueUserID;
        this.login = login;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.numberOfPosts = numberOfPosts;
    }

    public int getUniqueUserID() {
        return uniqueUserID;
    }

    public String getLogin() {
        return login;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "uniqueUserID=" + uniqueUserID +
                ", login='" + login + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", numberOfPosts=" + numberOfPosts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumUser forumUser = (ForumUser) o;
        return uniqueUserID == forumUser.uniqueUserID && sex == forumUser.sex && numberOfPosts == forumUser.numberOfPosts && login.equals(forumUser.login) && dateOfBirth.equals(forumUser.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueUserID, login, sex, dateOfBirth, numberOfPosts);
    }
}
