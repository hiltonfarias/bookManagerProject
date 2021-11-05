package com.github.hiltonfarias.bookManager.service;

import com.github.hiltonfarias.bookManager.dto.UserDTO;
import com.github.hiltonfarias.bookManager.model.User;

import java.util.List;

public interface InterfaceUserService {

    User consultEntity(String login);

    UserDTO consult(String login);

    List<UserDTO> list(String login);

    void valid(User... users);

    UserDTO save(UserDTO userDTO);
}
