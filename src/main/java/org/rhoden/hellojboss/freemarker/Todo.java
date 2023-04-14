package org.rhoden.hellojboss.freemarker;

public class Todo {
    private int priority;
    private String description;

    public Todo(int priority, String description) {
        this.priority = priority;
        this.description = description;
    }
    public int getPriority() {
        return priority;
    }
    public String getDescription() {
        return description;
    }
}
