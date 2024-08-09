package org.nikola.trelloclone.controller;

import lombok.RequiredArgsConstructor;
import org.nikola.trelloclone.entity.User;
import org.nikola.trelloclone.repository.UserRepository;
import org.nikola.trelloclone.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
