package com.sci.ro.finalproject.finalproject.repository;


import com.sci.ro.finalproject.finalproject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}