package com.sci.ro.finalproject.finalproject.service;

import com.sci.ro.finalproject.finalproject.model.CustomUserDetails;
import com.sci.ro.finalproject.finalproject.model.Users;
import com.sci.ro.finalproject.finalproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    /**
     * In this method we check the username authority on this platform.
     *
     *@param username the name chosen by the user
     *
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        Users user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("rol"));
//        for (Role role : user.getRoles()){
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
        return new CustomUserDetails(user.getUsername(), user.getPassword(), grantedAuthorities,user.getPasswordConfirm(), user.getId(),user.getRole(),user.getFirstName());
    }
}