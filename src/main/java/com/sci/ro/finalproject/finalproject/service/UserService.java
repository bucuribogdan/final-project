package com.sci.ro.finalproject.finalproject.service;

import com.sci.ro.finalproject.finalproject.model.Users;

/**
 * In this class, a new user service is created through the UserService builder, which through its methods
 * can import save new users and  find a user by username.
 */

public interface UserService {

    /**
     * This method saves a new user with the variables from the User class.
     *
     * @param user represents the new user
     */
    void save(Users user);

    /**
     * This methos
     * @param username
     * @return
     */

    Users findByUsername(String username);




}