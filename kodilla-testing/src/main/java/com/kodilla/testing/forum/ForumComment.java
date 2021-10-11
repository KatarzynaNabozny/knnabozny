package com.kodilla.testing.forum;

public class ForumComment {
    private ForumPost forumPost;
    private String commentBody;
    private String author;

    public ForumComment(String commentBody) {
        this.commentBody = commentBody;
    }

    public ForumComment(ForumPost forumPost) {
        this.forumPost = forumPost;
    }


