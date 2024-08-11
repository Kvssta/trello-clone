package org.nikola.trelloclone.controller;

import lombok.RequiredArgsConstructor;
import org.nikola.trelloclone.entity.User;
import org.nikola.trelloclone.repository.UserRepository;
import org.nikola.trelloclone.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable(name="userId") Integer userId) {
        return ResponseEntity.ok(userRepository.findById(userId).get());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name="userId") Integer userId) {
        userRepository.deleteById(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createNewUser(user));
    }

    @PutMapping()
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }
}
