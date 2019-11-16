package com.example.tasks.web.rest;

import com.example.tasks.domain.Task;
import com.example.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskRest {

    @Autowired TaskService taskService;


    @PostMapping("/api/tasks")
    public ResponseEntity<Task> postTask(@RequestBody Task task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(task));
    }

    @PatchMapping("/api/tasks/{taskId}")
    public ResponseEntity<Task> patchTask(@PathVariable Long taskId, @RequestBody Task task) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.update(taskId, task));
    }

    @DeleteMapping("/api/tasks/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        taskService.delete(taskId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("/api/tasks/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable Long taskId) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(taskId));
    }

    @GetMapping("/api/tasks")
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findAll());
    }

}
