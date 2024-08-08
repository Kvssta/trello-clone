package org.nikola.trelloclone.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.nikola.trelloclone.entity.UserOnTask;
import org.nikola.trelloclone.repository.UserOnTaskRepository;
import org.nikola.trelloclone.service.UserOnTaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-on-task")
@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
public class UserOnTaskController {

    private final UserOnTaskService userOnTaskService;
    private final UserOnTaskRepository userOnTaskRepository;
}
