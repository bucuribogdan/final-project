package com.sci.ro.finalproject.finalproject.service;

public interface SecurityService {
    String findLoggedInUsername();

    /**
     * This method keeps the user logged in for a certain amount of time.
     *
     * @param username the name chosen by the user
     * @param password profile access code
     */
    void autoLogin(String username, String password);
}