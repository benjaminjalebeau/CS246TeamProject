package com.example.authentication;

import java.util.ArrayList;

public class Directory {

    public ArrayList projectList;
    public ArrayList archiveList;
    public ArrayList employeeList;

    public PianoProject createProject(String serial, String model, String startedDate, Boolean priority){
        PianoProject newProject = new PianoProject();
        newProject.setSerial(serial);
        newProject.setModel(model);
        newProject.setStartedDate(startedDate);
        newProject.setPriority(priority);
        return newProject;
    }

    public void addProject(PianoProject project){
        projectList.add(project);
    }

    public void archiveProject(PianoProject project){
        projectList.remove(project);
        archiveList.add(project);
    }

    public Employee createEmployee(String employeeName, String password){
        Employee newEmployee = new Employee();
        newEmployee.setEmployeeName(employeeName);
        newEmployee.setPassword(password);
        return newEmployee;
    }

    public void addEmployee(Employee newEmployee){
        employeeList.add(newEmployee);
    }

}
