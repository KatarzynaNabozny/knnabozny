package com.kodilla.testing.forum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ForumUser {
    private String name;
    private String realName;
    private List<ForumPost>posts = new ArrayList<>();
    private List<ForumComment> comments = new LinkedList<>();

    public ForumUser(String name, String realName) {
        // name visible on com.kodilla.spring.forum
        this.name = name;
        //real name of the user
        this.realName = realName;
    }

    public void addPost(String author, String postBody) {
        //do nothing
    }

    public void addComment(ForumPost thePost, String author, String commentBody) {   // [16]
        // do nothing
    }

    public int getPostQuantity() {
        //return 100 temporarily
        return 100;
    }

    public int getCommentsQuantity() {                          // [21]
        // return 100 temporarily
        return 100;                                              // [22]
    }                                                           // [23]

    public ForumPost getPost(int postNumber) {                  // [24]
        // returning null means that the operation was unsuccessful
        return null;                                             // [25]
    }                                                           // [26]

    public ForumComment getComment(int commentNumber) {         // [27]
        // returning null means that the operation was unsuccessful
        return null;                                             // [28]
    }                                                           // [29]

    public boolean removePost(ForumPost thePost) {              // [30]
        // return true temporarily
        return true;                                             // [31]
    }                                                           // [32]

    public boolean removeComment(ForumComment theComment) {     // [33]
        // return true temporarily
        return true;                                             // [34]
    }                                                           // [35]

    public String getName() {                                   // [36]
        return name;                                             // [37]
    }

    public String getRealName() {                               // [39]
        return realName;                                         // [40]
    }
}
