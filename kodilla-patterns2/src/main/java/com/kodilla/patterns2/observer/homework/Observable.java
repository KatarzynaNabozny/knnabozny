package com.kodilla.patterns2.observer.homework;

public interface Observable {
    void registerObserver(com.kodilla.patterns2.observer.homework.Observer observer);
    void notifyObservers();
    void removeObserver(Observer observer);
}
