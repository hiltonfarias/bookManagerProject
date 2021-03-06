package com.github.hiltonfarias.bookManager.service.implementation;

import com.github.hiltonfarias.bookManager.converter.ConverterBook;
import com.github.hiltonfarias.bookManager.dto.BookDTO;
import com.github.hiltonfarias.bookManager.model.Book;
import com.github.hiltonfarias.bookManager.model.User;
import com.github.hiltonfarias.bookManager.repository.BookRepository;
import com.github.hiltonfarias.bookManager.repository.UserRepository;
import com.github.hiltonfarias.bookManager.service.InterfaceBookService;
import com.github.hiltonfarias.bookManager.service.InterfaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements InterfaceBookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ConverterBook converterBook;

    @Autowired
    private InterfaceUserService interfaceUserService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public BookDTO save(BookDTO bookDTO) {
        Book book = converterBook.converterDTOToEntity(bookDTO);
        interfaceUserService.valid(book.getUsers());
        Book savedBook = bookRepository.save(book);
        return converterBook.converterEntityToDTO(savedBook);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookDTO> list() {
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book book : bookRepository.findAll()) {
            bookDTOS.add(converterBook.converterEntityToDTO(book));
        }
        return bookDTOS;
    }

    @Override
    public List<BookDTO> consult(Long id) {
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book book : bookRepository.findAll()) {
            if (id.equals(book.getId())) {
                bookDTOS.add(converterBook.converterEntityToDTO(book));
            }
        }
        return bookDTOS;
    }

    public List<BookDTO> consultBookUser(Long id) {
        User user = userRepository.findById(id).get();
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book book : bookRepository.findAll()) {
            if (book.getUsers().equals(user)) {
                bookDTOS.add(converterBook.converterEntityToDTO(book));
            }
        }
        return bookDTOS;
    }

    @Override
    public BookDTO replace(BookDTO bookDTO, Long id) {
        Book book = bookRepository.findById(id).get();

        book.setAuthor(bookDTO.getAuthor());
        book.setCommonCover(bookDTO.getCommonCover());
        book.setIsbn(bookDTO.getIsbn());
        book.setLanguage(bookDTO.getLanguage());
        book.setPublisher(bookDTO.getPublisher());
        book.setTitle(bookDTO.getTitle());
        book.setYear(bookDTO.getYear());
        book.setRegistrationTime(LocalDateTime.now());

        return converterBook.converterEntityToDTO(bookRepository.save(book));
    }
}