package com.sci.ro.finalproject.finalproject.service;

import com.sci.ro.finalproject.finalproject.model.Users;
import com.sci.ro.finalproject.finalproject.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profRepo;

    public Optional<Users> getProfile(Long id){
        return profRepo.findById(id);
    }

    public Users saveProfile(Users a){
        return profRepo.save(a);
    }
}
