package com.sci.ro.finalproject.finalproject.service;

import com.sci.ro.finalproject.finalproject.model.Users;

public interface UserService {
    void save(Users user);

    Users findByUsername(String username);


}