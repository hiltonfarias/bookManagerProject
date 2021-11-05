package com.github.hiltonfarias.bookManager.converter;

import com.github.hiltonfarias.bookManager.dto.BookDTO;
import com.github.hiltonfarias.bookManager.model.Book;
import com.github.hiltonfarias.bookManager.service.InterfaceUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ConverterBook extends ConverterBase<Book, BookDTO> {

    @Autowired
    private InterfaceUserService userService;

    @Override
    public BookDTO converterEntityToDTO(Book entity) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Book, BookDTO>() {
            @Override
            protected void configure() {

            }
        });
        return modelMapper.map(entity, BookDTO.class);
    }

    @Override
    public Book converterDTOToEntity(BookDTO dto) {

        return Book
                .builder()
                .author(dto.getAuthor())
                .title(dto.getTitle())
                .isbn(dto.getIsbn())
                .language(dto.getLanguage())
                .commonCover(dto.getCommonCover())
                .registrationTime(LocalDateTime.now())
                .publisher(dto.getPublisher())
                .year(dto.getYear())
                .users(userService.consultEntity(dto.getUserDTO().getLogin()))
                .build();
    }
}
