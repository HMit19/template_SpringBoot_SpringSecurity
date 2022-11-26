package com.example.spring_security_boot.repository;

import com.example.spring_security_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
