package com.example.authentication;

public class Task {

    private String taskName;
    private String taskDescription;
    private Boolean inProgress;
    private String completedBy;
    private Boolean completed;
    private String workingNote;




    // Getters and Setters
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Boolean getInProgress() {
        return inProgress;
    }

    public void setInProgress(Boolean inProgress) {
        this.inProgress = inProgress;
    }

    public String getCompletedBy() {
        return completedBy;
    }

    public void setCompletedBy(String completedBy) {
        this.completedBy = completedBy;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getWorkingNote() {
        return workingNote;
    }

    public void setWorkingNote(String workingNote) {
        this.workingNote = workingNote;
    }
}
