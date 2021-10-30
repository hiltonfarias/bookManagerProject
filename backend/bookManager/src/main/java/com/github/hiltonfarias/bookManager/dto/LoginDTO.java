package com.github.hiltonfarias.bookManager.dto;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDTO {

    @NotBlank
    private String user;
    @NotBlank
    private String password;

    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(user,password);
    }
}
