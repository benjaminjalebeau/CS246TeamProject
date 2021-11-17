package com.example.authentication;

import java.util.ArrayList;

public class PianoProject {
    //Stores all project Data, and stores a list of tasks.//

    private String serial;
    private String model;
    private String startedDate;
    private String lastWorkedDate;
    private Boolean priority;

    public ArrayList taskList;

    public Task createNewTask(String taskName, String taskDescription){
        Task task = new Task();
        task.setTaskName(taskName);
        task.setCompleted(false);
        task.setTaskDescription(taskDescription);
        return task;
    }

    public void addTaskToProject(Task newTask){
        taskList.add(newTask);
    }

    public void markInProgressTask(Task currentTask, Employee employee){
        currentTask.setInProgress(true);
    }

    public void completeTask(Task currentTask, Employee employee){
        currentTask.setCompleted(true);
        currentTask.setCompletedBy(employee.getEmployeeName());
    }

    public void addNoteToTask(Task currentTask, String note){
        currentTask.setWorkingNote(note);
    }


    //Getters and Setters
    public String getSerial() {
        return serial;
    }
    public String getStartedDate() {
        return startedDate;
    }
    public String getLastWorkedDate() {
        return lastWorkedDate;
    }
    public Boolean getPriority() {
        return priority;
    }
    public String getModel() {
        return model;
    }
    public void setSerial(String serial) {
        this.serial = serial;
    }
    public void setStartedDate(String startedDate) {
        this.startedDate = startedDate;
    }
    public void setLastWorkedDate(String lastWorkedDate) {
        this.lastWorkedDate = lastWorkedDate;
    }
    public void setPriority(Boolean priority) {
        this.priority = priority;
    }
    public void setModel(String model) {
        this.model = model;
    }
}
