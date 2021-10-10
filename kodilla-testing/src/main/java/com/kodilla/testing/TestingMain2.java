package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;

public class TestingMain2 {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("TheForumUser");

        String result1 = simpleUser.getUsername();

        if (result1.equals("TheForumUserName")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
    }
}