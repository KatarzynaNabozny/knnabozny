package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public class Forum {
    private List<ForumUser> forumUsers = new ArrayList<>();

    public List<ForumUser> getUserList() {
        return forumUsers;
    }
    public void addForumUser(ForumUser forumUser){
        forumUsers.add(forumUser);
    }
}
