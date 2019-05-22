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

    /**
     * This method imports user data according to its id.
     *
     * @param id the user's identification number
     * @return user data
     */
    public Optional<Users> getProfile(Long id){
        return profRepo.findById(id);
    }

    /**
     * This method is saving the profile.
     *
     * @param a represents a user
     * @return saving a new user or updating the data of a current user
     */
    public Users saveProfile(Users a){
        return profRepo.save(a);
    }
}
