package com.sci.ro.finalproject.finalproject.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 *In this class we duplicate some variables in the User class.
 */
public class CustomUserDetails extends User {

    private Long id;
    private String role;
    private String passwordConfirm;
    private String firstName;


    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, String passwordConfirm, Long id,String role, String firstName) {
        super(username, password, authorities);
        this.id = id;
        this.role=role;
        this.firstName=firstName;
    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }
}
