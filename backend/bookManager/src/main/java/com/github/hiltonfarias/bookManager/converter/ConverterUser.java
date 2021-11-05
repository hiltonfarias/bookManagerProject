package com.github.hiltonfarias.bookManager.converter;

import com.github.hiltonfarias.bookManager.dto.UserDTO;
import com.github.hiltonfarias.bookManager.model.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class ConverterUser extends ConverterBase<User, UserDTO> {
    @Override
    public UserDTO converterEntityToDTO(User entity) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<User, UserDTO>() {
            @Override
            protected void configure() {

            }
        });
        return modelMapper.map(entity, UserDTO.class);
    }

    @Override
    public User converterDTOToEntity(UserDTO dto) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<UserDTO, User>() {
            @Override
            protected void configure() {

            }
        });
        return modelMapper.map(dto, User.class);
    }
}
