package com.takehomeassignment.tasks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takehomeassignment.tasks.model.Task;
import com.takehomeassignment.tasks.repository.TaskRepository;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public Task createTask(Task t) {
        return taskRepository.save(t);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).get();
    }

    public Task updateTask(Long taskId, Task updatedTask) {
        Task existingTask = taskRepository.findById(taskId).get();

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setCompleted(updatedTask.getCompleted());

        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}