package com.sci.ro.finalproject.finalproject.service;

import com.sci.ro.finalproject.finalproject.model.User;
import com.sci.ro.finalproject.finalproject.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profRepo;

    public Optional<User> getProfile(Integer id){
        return profRepo.findById(id);
    }

    public User saveProfile(User a){
        return profRepo.save(a);
    }
}
