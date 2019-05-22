package com.sci.ro.finalproject.finalproject.service;

import com.sci.ro.finalproject.finalproject.model.Users;
import com.sci.ro.finalproject.finalproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * This method saves encrypted passwords in the database.
     *
     * @param user represents the new user
     */
    @Override
    public void save(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPasswordConfirm(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
//        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    /**
     * This method looks for a user by username.
     *
     * @param username the name chosen by the user
     * @return true if username exists in database
     * @return false if username does not exists in database
     */
    @Override
    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}