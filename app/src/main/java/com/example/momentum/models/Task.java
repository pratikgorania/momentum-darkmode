package com.example.momentum.models;

public class Task {
    private String id; // need this to save task in firebase
    private String title;
    private String description;
    private String category;
    private String priority; //High,medium,low priority
    private String deadline;
    private String status;   //to-do,in progress & finished
    private boolean isCompleted;

    // need this for firebase
    public Task() {
    }

    //constructrs
    public Task(String id, String title, String description, String category, String priority,
                String deadline, String status, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.priority = priority;
        this.deadline = deadline;
        this.status = status;
        this.isCompleted = isCompleted;
    }

    //get and set ters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
    public String getDeadline() { return deadline; }
    public void setDeadline(String deadline) { this.deadline = deadline; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public boolean isCompleted() { return isCompleted; }
    public void setCompleted(boolean completed) { isCompleted = completed; }
}
