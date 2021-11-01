package com.github.hiltonfarias.bookManager.service.implementation;

import com.github.hiltonfarias.bookManager.model.User;
import com.github.hiltonfarias.bookManager.service.InterfaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
public class AuthenticationService {
//    public class AuthenticationService implements UserDetailsService {

//    @Autowired
//    private InterfaceUserService interfaceUserService;

//    @Override
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        User user = interfaceUserService.consultEntity(login);
//
//        if (!validateUser(user)){
//            throw new UsernameNotFoundException("-> user [" + user.getUsername() + "] without permission");
//        }
//        return user;
//    }

//    private boolean validateUser(User user){
//        boolean userValid = false;
//        if (user != null && user.getPermissionType() != null && user.isActive()) {
//            userValid = true;
//        }
//        return userValid;
//    }
}
