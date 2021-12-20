package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public static final String SHOPPINGTASK = "SHOPPINGTASK";
    public static final String PAINTINGTASK = "PAINTINGTASK";
    public static final String DRIVINGTASK = "DRIVINGTASK";

    public final Tasks makeTasks(final String tasksClass) {
        switch (tasksClass) {
            case SHOPPINGTASK:
                return new ShoppingTask("buying", "apple", 12);
            case PAINTINGTASK:
                return new PaintingTask("painting", "blue", "wall");
            case DRIVINGTASK:
                return new DrivingTask("driving", "Paris", "car");
            default:
                return null;
        }
    }
}
