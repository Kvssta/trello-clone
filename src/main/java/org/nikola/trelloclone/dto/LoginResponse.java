package org.nikola.trelloclone.dto;

import lombok.Data;
import org.nikola.trelloclone.entity.User;

@Data
public class LoginResponse {
    private String token;

    private long expiresIn;

    private User user;

}
