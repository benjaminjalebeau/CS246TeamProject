package com.example.authentication.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.authentication.AddNewTask;
import com.example.authentication.MainActivity;
import com.example.authentication.Model.ToDoModel;
import com.example.authentication.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.MyViewHolder> {

    private List<ToDoModel> todolist;
    private MainActivity activity;
    private FirebaseFirestore firestore;

    public ToDoAdapter(MainActivity mainActivity, List<ToDoModel> todolist) {
        this.todolist = todolist;
        activity = mainActivity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.each_task, parent, false);
        firestore = FirebaseFirestore.getInstance();

        return new MyViewHolder(view);
    }

    //Method to delete tasks
    public void deleteTask(int position) {
        ToDoModel toDoModel = todolist.get(position);
        firestore.collection("task").document(toDoModel.TaskId).delete();
        todolist.remove(position);
        notifyItemRemoved(position);
    }

    public Context getContext() {
        return activity;
    }

    //Method to edit tasks
//    public void editTask(int position) {
//        ToDoModel toDoModel = todolist.get(position);
//
//        Bundle bundle = new Bundle();
//        bundle.putString("task", toDoModel.getTask());
//        bundle.putString("due", toDoModel.getTask());
//        bundle.putString("id", toDoModel.TaskId);
//
//        AddNewTask addNewTask = new AddNewTask();
//        addNewTask.setArguments(bundle);
//        addNewTask.show(activity.getSupportFragmentManager(), addNewTask.getTag());
//    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ToDoModel toDoModel = todolist.get(position);
        holder.mcheckbox.setText(toDoModel.getTask());
        holder.dueDate.setText("Due on " + toDoModel.getDue());

        holder.mcheckbox.setChecked(toBoolean(toDoModel.getStatus()));

        holder.mcheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    firestore.collection("task").document(toDoModel.TaskId).update("status", 1);
                }else {
                    firestore.collection("task").document(toDoModel.TaskId).update("status", 0);
                }
            }
        });
    }

    private boolean toBoolean(int status) {
        return status != 0;
    }


    @Override
    public int getItemCount() {
        return todolist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView dueDate;
        CheckBox mcheckbox;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            dueDate = itemView.findViewById(R.id.dueDate);
            mcheckbox = itemView.findViewById(R.id.mcheckbox);

        }
    }
}
