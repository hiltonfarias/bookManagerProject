package com.github.hiltonfarias.bookManager.resource;

import com.github.hiltonfarias.bookManager.dto.LoginDTO;
import com.github.hiltonfarias.bookManager.dto.TokenDTO;
import com.github.hiltonfarias.bookManager.service.implementation.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

//@RestController
//@RequestMapping("/authentication")
//public class AuthenticationResource extends BaseResource<TokenDTO> {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private TokenService tokenService;
//
//    @PostMapping
//    public ResponseEntity<TokenDTO> authenticate(@RequestBody @Valid LoginDTO loginDTO) {
//        UsernamePasswordAuthenticationToken loginData = loginDTO.converter();
//
//        try {
//            Authentication authentication = authenticationManager.authenticate(loginData);
//            String token = tokenService.generateToken(authentication);
//            return answerSuccessWithItem(new TokenDTO(token, "Bearer"));
//        } catch (AuthenticationException exception) {
//            return answerUnsuccessfulRequest();
//        }
//    }
//}
