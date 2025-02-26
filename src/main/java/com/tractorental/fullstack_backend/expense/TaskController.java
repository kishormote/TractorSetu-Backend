package com.tractorental.fullstack_backend.expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
@CrossOrigin(origins = "*")
public class TaskController
{
    @Autowired
    private TaskService taskService;

    @PostMapping("/tractor-owner-tasks/{ownerId}")
    public ResponseEntity<TractorOwnerTask> createTractorOwnerTask(
            @PathVariable(name = "ownerId") long ownerId,
            @RequestBody TaskRequest taskRequest)
    {
        TractorOwnerTask newTask = taskService.createTask(ownerId, taskRequest);
        return ResponseEntity.ok(newTask);
    }

    @PutMapping("/tractor-owner-tasks/{ownerId}")
    public ResponseEntity<List<TractorOwnerTask>> updateMultipleTasks(
            @PathVariable(name = "ownerId") long ownerId,
            @RequestBody TaskUpdateRequest updateRequest)
    {
        List<TractorOwnerTask> updatedTasks = taskService.updateTasks(ownerId, updateRequest.getTasks());
        return ResponseEntity.ok(updatedTasks);
    }

    @GetMapping("/tractor-owner-tasks/{ownerId}")
    public ResponseEntity<List<TractorOwnerTask>> getAllTasks(@PathVariable(name = "ownerId") long ownerId)
    {
        List<TractorOwnerTask> tasks = taskService.getAllTasksByOwner(ownerId);
        return ResponseEntity.ok(tasks);
    }
}
