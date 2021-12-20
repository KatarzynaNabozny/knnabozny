package com.kodilla.patterns.factory.tasks;

public final class ShoppingTask implements Tasks {

    private boolean isTaskExecuted;
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public void executeTask() {
        isTaskExecuted = true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }


    @Override
    public boolean isTaskExecuted() {
        return isTaskExecuted;
    }

}