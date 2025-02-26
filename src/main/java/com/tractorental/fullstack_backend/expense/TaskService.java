package com.tractorental.fullstack_backend.expense;

import com.tractorental.fullstack_backend.auth.User;
import com.tractorental.fullstack_backend.auth.UserRepository;
import com.tractorental.fullstack_backend.infra.DuplicateTaskException;
import com.tractorental.fullstack_backend.infra.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService
{
    @Autowired
    private TractorOwnerTaskRepository taskRepository;

    @Autowired
    private UserRepository ownerRepository;

    public TractorOwnerTask createTask(long ownerId, TaskRequest taskRequest)
    {
        User tractorOwner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with ID: " + ownerId));

        Optional<TractorOwnerTask> existingTask = taskRepository.findByTractorOwnerAndTaskName(tractorOwner, taskRequest.getTaskName());
        if (existingTask.isPresent())
        {
            throw new DuplicateTaskException("Task with the name '" + taskRequest.getTaskName() + "' already exists for this owner.");
        }

        TractorOwnerTask task = new TractorOwnerTask();
        task.setTractorOwner(tractorOwner);
        task.setTaskName(taskRequest.getTaskName());
        task.setPrice(taskRequest.getPrice());

        return taskRepository.save(task);
    }

    public List<TractorOwnerTask> updateTasks(long ownerId, List<TaskRequest> taskRequests)
    {
        User tractorOwner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with ID: " + ownerId));

        return taskRequests.stream().map(request ->
        {
            TractorOwnerTask task = taskRepository.findById(request.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Task not found with ID: " + request.getId()));

            task.setTaskName(request.getTaskName());
            task.setPrice(request.getPrice());
            return taskRepository.save(task);
        }).collect(Collectors.toList());
    }

    public List<TractorOwnerTask> getAllTasksByOwner(long ownerId)
    {
        if (!ownerRepository.existsById(ownerId))
        {
            throw new ResourceNotFoundException("Owner not found with ID: " + ownerId);
        }
        return taskRepository.findByTractorOwner(ownerRepository.findById(ownerId).get());
    }
}
