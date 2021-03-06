package com.github.hiltonfarias.bookManager.service;

import com.github.hiltonfarias.bookManager.dto.BookDTO;

import java.util.List;

public interface InterfaceBookService {

    BookDTO save(BookDTO bookDTO);

    void delete(Long id);

    List<BookDTO> list();

    List<BookDTO> consult(Long idUser);

    BookDTO replace(BookDTO bookDTO, Long id);

    List<BookDTO> consultBookUser(Long id);
}
