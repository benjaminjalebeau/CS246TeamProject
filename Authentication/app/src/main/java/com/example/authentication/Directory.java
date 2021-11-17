package com.example.authentication;

import java.util.ArrayList;

public class Directory {

    public ArrayList projectList;
    public ArrayList archiveList;

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

}
