package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        for (int i = 0; i < tasks.size(); i++) {
            Task element = tasks.get(i);
            if (element.getPriority() > task.getPriority()) {
                index++;
            } else if (element.getPriority() < task.getPriority()) {
                tasks.add(i, get);
            }
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }
}