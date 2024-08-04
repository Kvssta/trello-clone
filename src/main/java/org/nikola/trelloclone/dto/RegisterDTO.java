package org.nikola.trelloclone.dto;

import lombok.Data;

@Data
public class RegisterDTO {

    private String email;
    private String username;
    private String password;
    private String profilePicture;
}
