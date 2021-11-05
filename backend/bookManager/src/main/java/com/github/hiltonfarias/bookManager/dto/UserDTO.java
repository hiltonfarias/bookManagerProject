package com.github.hiltonfarias.bookManager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonInclude(NON_NULL)
public class UserDTO {

    @NotBlank
    private String login;

    private String password;

    private String fullName;

    private String email;

    private LocalDate birthDate;

    private boolean active = true;
}
