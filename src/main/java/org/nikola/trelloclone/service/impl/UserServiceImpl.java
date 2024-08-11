package org.nikola.trelloclone.service.impl;

import lombok.RequiredArgsConstructor;
import org.nikola.trelloclone.entity.Role;
import org.nikola.trelloclone.entity.User;
import org.nikola.trelloclone.repository.UserRepository;
import org.nikola.trelloclone.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createNewUser(User user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
        newUser.setRole(Role.valueOf(user.getRole().name()));
        userRepository.save(newUser);
        return newUser;
    }
}
