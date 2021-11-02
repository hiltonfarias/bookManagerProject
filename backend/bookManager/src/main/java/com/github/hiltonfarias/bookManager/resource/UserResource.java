package com.github.hiltonfarias.bookManager.resource;

import com.github.hiltonfarias.bookManager.dto.UserDTO;
import com.github.hiltonfarias.bookManager.model.User;
import com.github.hiltonfarias.bookManager.repository.UserRepository;
import com.github.hiltonfarias.bookManager.service.InterfaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/users")
public class UserResource extends BaseResource<UserDTO> {

    @Autowired
    private InterfaceUserService interfaceUserService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> list(@RequestParam String login) {
        List<UserDTO> userDTOS = interfaceUserService.list(login);
        return answerListOfItems(userDTOS);
    }

    @GetMapping("/{login}")
    public ResponseEntity<UserDTO> consult(@PathVariable String login) {
        return answerSuccessWithItem(interfaceUserService.consult(login));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
        return answerCreatedItem(interfaceUserService.save(userDTO));
    }
}
