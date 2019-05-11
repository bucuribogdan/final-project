package com.sci.ro.finalproject.finalproject.service;

import com.sci.ro.finalproject.finalproject.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);


}