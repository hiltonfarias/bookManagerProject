package com.github.hiltonfarias.bookManager.service.implementation;

import com.github.hiltonfarias.bookManager.converter.ConverterBook;
import com.github.hiltonfarias.bookManager.dto.BookDTO;
import com.github.hiltonfarias.bookManager.model.Book;
import com.github.hiltonfarias.bookManager.repository.BookRepository;
import com.github.hiltonfarias.bookManager.service.InterfaceBookService;
import com.github.hiltonfarias.bookManager.service.InterfaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService implements InterfaceBookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ConverterBook converterBook;

    @Autowired
    private InterfaceUserService interfaceUserService;

    @Override
    public BookDTO save(BookDTO bookDTO) {
        BookDTO bookDTOReturn = null;

        if (bookDTO.getIsSaved()) {
            Book book = converterBook.converterDTOToEntity(bookDTO);
            interfaceUserService.valid(book.getUsers());
            Book savedBook = bookRepository.save(book);
            bookDTOReturn = converterBook.converterEntityToDTO(savedBook);
        }
        return bookDTOReturn;
    }
}
