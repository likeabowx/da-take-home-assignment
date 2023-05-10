package com.takehomeassignment.tasks.controller;

import java.util.List;

import com.takehomeassignment.tasks.exceptions.BadInputException;
import com.takehomeassignment.tasks.exceptions.NoSuchElementFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.takehomeassignment.tasks.model.Task;
import com.takehomeassignment.tasks.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    TaskService taskService;

    @RequestMapping(value="/tasks", method=RequestMethod.POST)
    public Task createTask(@RequestBody Task t) {
        if (t.getTitle().isBlank()) {
            throw new BadInputException("Title is required");
        }

        return taskService.createTask(t);
    }

    @RequestMapping(value="/tasks", method=RequestMethod.GET)
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @RequestMapping(value="/tasks/{taskId}", method=RequestMethod.GET)
    public Task getTaskById(@PathVariable(value = "taskId") Long id) {
        if (!taskService.isExistingTask(id)) {
            throw new NoSuchElementFoundException("Task ID " + id + " does not exist");
        }

        return taskService.getTaskById(id);
    }

    @RequestMapping(value="/tasks/{taskId}", method=RequestMethod.PUT)
    public Task updateTask(@PathVariable(value = "taskId") Long id, @RequestBody Task updatedTask) {
        if (!taskService.isExistingTask(id)) {
            throw new NoSuchElementFoundException("Task ID " + id + " does not exist");
        }

        if (updatedTask.getTitle() != null && updatedTask.getTitle().isEmpty()) {
            throw new BadInputException("Title cannot be empty");
        }

        return taskService.updateTask(id, updatedTask);
    }

    @RequestMapping(value="/tasks/{taskId}", method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteEmployees(@PathVariable(value = "taskId") Long id) {
        if (!taskService.isExistingTask(id)) {
            throw new NoSuchElementFoundException("Task ID " + id + " does not exist");
        }

        taskService.deleteTask(id);

        return ResponseEntity.ok().body("Successfully deleted task " + id);
    }
}
