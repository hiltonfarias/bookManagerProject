package com.github.hiltonfarias.bookManager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class TokenDTO {

    private String token;
    private String type;
}
