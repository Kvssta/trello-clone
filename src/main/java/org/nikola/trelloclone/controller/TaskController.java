package org.nikola.trelloclone.controller;

import lombok.RequiredArgsConstructor;
import org.nikola.trelloclone.entity.Task;
import org.nikola.trelloclone.entity.TaskStatus;
import org.nikola.trelloclone.repository.TaskRepository;
import org.nikola.trelloclone.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class TaskController {

    private final TaskService taskService;
    private final TaskRepository taskRepository;

    @PutMapping("/status")
    public ResponseEntity<Task> changeStatus(@RequestBody Task task, @RequestParam(name="newStatus") String newStatus) {
        return ResponseEntity.ok(taskService.changeStatus(task, newStatus));
    }
}
