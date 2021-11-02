package com.github.hiltonfarias.bookManager.resource;

import com.github.hiltonfarias.bookManager.dto.BookDTO;
import com.github.hiltonfarias.bookManager.service.InterfaceBookService;
import com.github.hiltonfarias.bookManager.service.InterfaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/books")
public class BookResource extends BaseResource<BookDTO>{

    @Autowired
    private InterfaceBookService interfaceBookService;
    @Autowired
    private InterfaceUserService interfaceUserService;

    @GetMapping
    public ResponseEntity<List<BookDTO>> list() {
        return answerListOfItems(interfaceBookService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<BookDTO>> consult(@PathVariable Long id) {
        return answerListOfItems(interfaceBookService.consult(id));
    }

    @GetMapping("/booksuser/{idUser}")
    public ResponseEntity<List<BookDTO>> consultBookUser(@PathVariable Long idUser) {
        return answerListOfItems(interfaceBookService.consultBookUser(idUser));
    }

    @PostMapping
    public ResponseEntity<BookDTO> create(@RequestBody BookDTO bookDTO) {
        return answerCreatedItem(interfaceBookService.save(bookDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> update(@RequestBody BookDTO bookDTO, @PathVariable Long id) {
        return answerSuccess(interfaceBookService.replace(bookDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        interfaceBookService.delete(id);
        return answerDeletedSuccess();
    }
}
