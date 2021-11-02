package com.github.hiltonfarias.bookManager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonInclude(NON_NULL)
public class BookDTO {

    private Long id;

    @NotBlank
    private String author;

    @NotBlank
    private String title;

    @NotBlank
    private String publisher;

    @NotBlank
    private String language;

    @NotBlank
    private String commonCover;

    @NotBlank
    private String isbn;

//    private LocalDateTime registrationTime;

    @NotBlank
    private String year;

    @NotNull
    private UserDTO userDTO;

    private Boolean isSaved = false;
}
