package com.example.momentum.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import java.util.Calendar;

import com.example.momentum.R;
import com.example.momentum.models.Task;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddTaskActivity extends AppCompatActivity {

    EditText editTextTitle, editTextDescription, editTextCategory;
    Spinner spinnerPriority, spinnerStatus;
    Button buttonSelectDeadline, buttonSubmitTask, buttonViewTasks;
    TextView textViewSelectedDeadline;
    FloatingActionButton fabQuickAction;

    String selectedDeadline = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Apply the dark/light theme based on stored preference
        SharedPreferences sharedPref = getSharedPreferences("ThemePrefs", MODE_PRIVATE);
        boolean isDarkMode = sharedPref.getBoolean("dark_mode", false);
        AppCompatDelegate.setDefaultNightMode(
                isDarkMode ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO
        );

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_task);

        // Input fields
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextCategory = findViewById(R.id.editTextCategory);
        spinnerPriority = findViewById(R.id.spinnerPriority);
        spinnerStatus = findViewById(R.id.spinnerStatus);
        buttonSelectDeadline = findViewById(R.id.buttonSelectDeadline);
        textViewSelectedDeadline = findViewById(R.id.textViewSelectedDeadline);
        buttonSubmitTask = findViewById(R.id.buttonSubmitTask);
        buttonViewTasks = findViewById(R.id.buttonViewTasks);
        fabQuickAction = findViewById(R.id.fabQuickAction);

        // Priority dropdown
        ArrayAdapter<String> priorityAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item,
                new String[]{"High", "Medium", "Low"});
        priorityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPriority.setAdapter(priorityAdapter);

        // Status dropdown
        ArrayAdapter<String> statusAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item,
                new String[]{"To-do", "In Progress", "Completed"});
        statusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStatus.setAdapter(statusAdapter);

        // Date picker
        buttonSelectDeadline.setOnClickListener(v -> showDatePicker());

        // Submit task
        buttonSubmitTask.setOnClickListener(v -> submitTask());

        // View all tasks
        buttonViewTasks.setOnClickListener(v -> {
            Intent intent = new Intent(AddTaskActivity.this, TaskListActivity.class);
            startActivity(intent);
        });
    }

    private void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    selectedDeadline = selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay;
                    textViewSelectedDeadline.setText("Deadline: " + selectedDeadline);
                },
                year, month, day);
        datePickerDialog.show();
    }

    private void submitTask() {
        String title = editTextTitle.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        String category = editTextCategory.getText().toString().trim();
        String priority = spinnerPriority.getSelectedItem().toString();
        String status = spinnerStatus.getSelectedItem().toString();

        if (title.isEmpty()) {
            editTextTitle.setError("Title is required");
            return;
        }

        Task task = new Task(
                null,
                title,
                description,
                category,
                priority,
                selectedDeadline,
                status,
                false
        );

        // Just for testing
        Toast.makeText(this, "Task Created (not saved yet)", Toast.LENGTH_SHORT).show();
    }
}
