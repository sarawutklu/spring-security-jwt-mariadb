package com.github.sarawutklu.spring_security_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.github.sarawutklu.spring_security_jwt.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
