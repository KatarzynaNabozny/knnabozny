package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class StudentTask implements Observable {
    private final List<com.kodilla.patterns2.observer.homework.Observer> observers;
    private final List<String> messages;
    private final String name;

    public StudentTask(String name) {
        observers = new ArrayList<>();
        messages = new ArrayList<>();
        this.name = name;
    }

    public void addTask(String task) {
        messages.add(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(com.kodilla.patterns2.observer.homework.Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (com.kodilla.patterns2.observer.homework.Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public List<String> getMessages() {
        return messages;
    }

    public String getName() {
        return name;
    }

}

