package org.nikola.trelloclone.controller;

import lombok.RequiredArgsConstructor;
import org.nikola.trelloclone.dto.NewUserTaskDTO;
import org.nikola.trelloclone.entity.UserTask;
import org.nikola.trelloclone.repository.UserTaskRepository;
import org.nikola.trelloclone.service.UserTaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-task")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class UserTaskController {

    private final UserTaskService userTaskService;
    private final UserTaskRepository userTaskRepository;

    @GetMapping("/{userTaskId}")
    public ResponseEntity<UserTask> getUserTask(@PathVariable Integer userTaskId) {
        return ResponseEntity.ok(userTaskRepository.findById(userTaskId).orElse(null));
    }

    @PostMapping()
    public ResponseEntity<UserTask> createUserTask(@RequestBody NewUserTaskDTO userTask) {
        return ResponseEntity.ok(userTaskService.createUserTask(userTask));
    }
}
