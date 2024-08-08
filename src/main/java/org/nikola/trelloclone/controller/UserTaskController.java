package org.nikola.trelloclone.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.nikola.trelloclone.entity.UserTask;
import org.nikola.trelloclone.repository.UserTaskRepository;
import org.nikola.trelloclone.service.UserTaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-task")
@RequiredArgsConstructor
public class UserTaskController {

    private final UserTaskService userTaskService;
    private final UserTaskRepository userTaskRepository;

    @GetMapping()
    @ApiOperation(value = "Get all user on tasks")
    public ResponseEntity<List<UserTask>> getAllUserOnTasks() {
        return ResponseEntity.ok(userTaskRepository.findAll());
    }
}
