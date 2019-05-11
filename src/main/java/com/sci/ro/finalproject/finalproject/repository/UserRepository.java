package com.sci.ro.finalproject.finalproject.repository;


import com.sci.ro.finalproject.finalproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}