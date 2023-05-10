package com.takehomeassignment.tasks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
        return taskService.createTask(t);
    }

    @RequestMapping(value="/tasks", method=RequestMethod.GET)
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @RequestMapping(value="/tasks/{taskId}", method=RequestMethod.GET)
    public Task getTaskById(@PathVariable(value = "taskId") Long id) {
        return taskService.getTaskById(id);
    }

    @RequestMapping(value="/tasks/{taskId}", method=RequestMethod.PUT)
    public Task updateTask(@PathVariable(value = "taskId") Long id, @RequestBody Task taskDetails) {
        return taskService.updateTask(id, taskDetails);
    }

    @RequestMapping(value="/tasks/{taskId}", method=RequestMethod.DELETE)
    public void deleteEmployees(@PathVariable(value = "taskId") Long id) {
        taskService.deleteTask(id);
    }
}
