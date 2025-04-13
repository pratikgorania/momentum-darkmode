package com.example.momentum.activities;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.momentum.R;
import com.example.momentum.models.Task;
import com.example.momentum.adapters.TaskAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.content.Intent;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;
    private List<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            //Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
           // v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            //return insets;
        //});

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            finish();
        });


        recyclerView = findViewById(R.id.recyclerViewTasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //just to test if working, when database set remvoe this please
        taskList = new ArrayList<>();
        taskList.add(new Task(null, "Buy food", "Milk, Eggs, Bread", "Personal", "High", "2025-04-13", "To-do", false));
        taskList.add(new Task(null, "Workout", "Leg day ", "Fitness", "Low", "2025-04-15", "Completed", true));

        taskAdapter = new TaskAdapter(taskList);
        recyclerView.setAdapter(taskAdapter);


        FloatingActionButton fabAddTask = findViewById(R.id.fabAddTask);
        fabAddTask.bringToFront();
        fabAddTask.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AddTaskActivity.class));
        });

    }

}