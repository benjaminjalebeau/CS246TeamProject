package com.example.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Directory extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public ArrayList projectList;
    public ArrayList archiveList;
    public ArrayList employeeList;

/*
Give the user ability to logout of app and be redirected to the Login Activity.
 */
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }
}

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
