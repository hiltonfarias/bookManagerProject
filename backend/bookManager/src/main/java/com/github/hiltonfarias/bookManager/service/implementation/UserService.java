package com.github.hiltonfarias.bookManager.service.implementation;

import com.github.hiltonfarias.bookManager.converter.ConverterUser;
import com.github.hiltonfarias.bookManager.dto.UserDTO;
import com.github.hiltonfarias.bookManager.exceptions.BusinessException;
import com.github.hiltonfarias.bookManager.model.User;
import com.github.hiltonfarias.bookManager.repository.UserRepository;
import com.github.hiltonfarias.bookManager.service.InterfaceUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements InterfaceUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConverterUser converterUser;

    @Override
    @Transactional
    public User consultEntity(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public UserDTO consult(String login) {
        User user = consultEntity(login);
        return converterUser.converterEntityToDTO(user);
    }

    @Override
    public List<UserDTO> list(String login) {
        List<User> users = userRepository.findAll();

        return converterUser.converterEntitiesToDTOs(
                users.stream().filter(user -> !user.getLogin().equals(login)).collect(Collectors.toList())
        );
    }

    @Override
    public void valid(User... users) {
        Arrays.asList(users).stream().forEach(user -> {
            if (user == null) {
                throw new BusinessException("User does not exist");
            }
        });
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        return converterUser.converterEntityToDTO(userRepository.save(converterUser.converterDTOToEntity(userDTO)));
    }
}
