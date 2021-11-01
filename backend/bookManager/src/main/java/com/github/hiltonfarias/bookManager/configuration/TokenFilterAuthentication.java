package com.github.hiltonfarias.bookManager.configuration;

import com.github.hiltonfarias.bookManager.model.User;
import com.github.hiltonfarias.bookManager.repository.UserRepository;
import com.github.hiltonfarias.bookManager.service.implementation.TokenService;

//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

//public class TokenFilterAuthentication {
////    public class TokenFilterAuthentication extends OncePerRequestFilter {
//    private final TokenService tokenService;
//    private final UserRepository userRepository;
//
//    public TokenFilterAuthentication(TokenService tokenService, UserRepository userRepository) {
//        this.tokenService = tokenService;
//        this.userRepository = userRepository;
//    }
//
////    @Override
////    protected void doFilterInternal(HttpServletRequest request,
////                                    HttpServletResponse response,
////                                    FilterChain filterChain) throws ServletException, IOException {
////        String token = retrieveToken(request);
////        boolean valid = tokenService.tokenIsValid(token);
////        if (valid) {
////            authenticateUser(token);
////        }
////        filterChain.doFilter(request,response);
////    }
//
////    private void authenticateUser(String token) {
////        Long userId = tokenService.getUserId(token);
////        User user = userRepository.findById(userId).get();
////        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null,
////                user.getAuthorities());
////        SecurityContextHolder.getContext().setAuthentication(authentication);
////    }
//
//    private String retrieveToken(HttpServletRequest httpServletRequest) {
//        String token = httpServletRequest.getHeader("Authorization");
//        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
//            return null;
//        }
//        return token.substring(7,token.length());
//    }
//}
