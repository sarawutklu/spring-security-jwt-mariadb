package com.github.sarawutklu.spring_security_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.github.sarawutklu.spring_security_jwt.entity.Role;
import com.github.sarawutklu.spring_security_jwt.entity.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}