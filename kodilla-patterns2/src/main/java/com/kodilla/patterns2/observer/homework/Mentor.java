package com.kodilla.patterns2.observer.homework;


public class Mentor implements Observer {
    private final String username;
    private int updateCount;

    public Mentor(String username) {
        this.username = username;
    }

    @Override
    public void update(StudentTask studentTask) {
        System.out.println(username + ": New task to verify " + studentTask.getName() + "\n" +
                " (total: " + studentTask.getMessages().size() + " messages)");
        updateCount++;
    }

    public String getUsername() {
        return username;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
