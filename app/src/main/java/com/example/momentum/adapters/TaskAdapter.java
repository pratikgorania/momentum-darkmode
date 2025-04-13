package com.example.momentum.adapters;

import com.example.momentum.R;
import com.example.momentum.models.Task;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;






public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> taskList;

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    //viewholf
    // der class for references
    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView title, category, priority, deadline;

        public TaskViewHolder(@NonNull View itemView) {

            super(itemView);
            title = itemView.findViewById(R.id.textViewTitle);
            category = itemView.findViewById(R.id.textViewCategory);
            priority = itemView.findViewById(R.id.textViewPriority);
            deadline = itemView.findViewById(R.id.textViewDeadline);

        }


        public void bind(Task task) {

            title.setText(task.getTitle());

            category.setText("Category: " + task.getCategory());

            priority.setText("Priority: " + task.getPriority());

            deadline.setText("Deadline: " + task.getDeadline());
        }
    }

    @Override
    public int getItemCount() {

        return taskList.size();

    }

    // for updating the list in real tiem
    public void updateList(List<Task> newTasks) {
        taskList = newTasks;
        notifyDataSetChanged();
    }




    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.bind(taskList.get(position));
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }



}


