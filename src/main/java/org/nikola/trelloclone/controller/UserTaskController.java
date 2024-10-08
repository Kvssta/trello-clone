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

    @PostMapping()
    public ResponseEntity<UserTask> createUserTask(@RequestBody NewUserTaskDTO userTask) {
        return ResponseEntity.ok(userTaskService.createUserTask(userTask));
    }

    @PutMapping()
    public ResponseEntity<UserTask> updateUserTask(@RequestBody NewUserTaskDTO userTask) {
        return ResponseEntity.ok(userTaskService.updateUserTask(userTask));
    }

    @DeleteMapping("/{userTaskId}")
    public ResponseEntity<Void> deleteUserTask(@PathVariable(name = "userTaskId") Integer userTaskId) {
        userTaskRepository.deleteById(userTaskId);
        return ResponseEntity.noContent().build();
    }
}
