package org.nikola.trelloclone.controller;

import lombok.RequiredArgsConstructor;
import org.nikola.trelloclone.dto.LoginDTO;
import org.nikola.trelloclone.dto.LoginResponse;
import org.nikola.trelloclone.dto.RegisterDTO;
import org.nikola.trelloclone.entity.User;
import org.nikola.trelloclone.repository.UserRepository;
import org.nikola.trelloclone.security.service.AuthenticationService;
import org.nikola.trelloclone.security.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;


    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterDTO registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginDTO loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        loginResponse.setUser(
                userRepository.findByEmail(loginUserDto.getEmail()).orElseThrow(() -> new NoSuchElementException("No user found"))
        );

        return ResponseEntity.ok(loginResponse);
    }
}