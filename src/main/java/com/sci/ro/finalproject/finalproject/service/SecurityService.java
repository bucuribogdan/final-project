package com.sci.ro.finalproject.finalproject.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}