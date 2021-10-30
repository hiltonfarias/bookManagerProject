package com.github.hiltonfarias.bookManager.repository;

import com.github.hiltonfarias.bookManager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
