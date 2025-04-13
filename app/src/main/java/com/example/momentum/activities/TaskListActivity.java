package com.example.momentum.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.momentum.R;

public class TaskListActivity extends AppCompatActivity {

    LinearLayout taskListContainer;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        taskListContainer = findViewById(R.id.taskListContainer);
        inflater = LayoutInflater.from(this);


        //replace with firebase after

        String[][] tasks = {
                {"Do Homework", "School", "High", "2025-04-14"},
                {"Buy Groceries", "Errands", "Medium", "2025-04-15"},
                {"Read Book", "Personal", "Low", "2025-04-16"}
        };
        for (String[] task : tasks) {
            View taskView = inflater.inflate(R.layout.item_task, taskListContainer, false);

            TextView title = taskView.findViewById(R.id.textViewTitle);
            TextView category = taskView.findViewById(R.id.textViewCategory);
            TextView priority = taskView.findViewById(R.id.textViewPriority);
            TextView deadline = taskView.findViewById(R.id.textViewDeadline);

            title.setText(task[0]);
            category.setText("Category: " + task[1]);
            priority.setText("Priority: " + task[2]);
            deadline.setText("Deadline: " + task[3]);

            taskListContainer.addView(taskView);
        }

        //bacb utton
        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());
    }
}
