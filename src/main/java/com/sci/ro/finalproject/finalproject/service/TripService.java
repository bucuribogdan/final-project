package com.sci.ro.finalproject.finalproject.service;


import com.sci.ro.finalproject.finalproject.model.Trip;
import com.sci.ro.finalproject.finalproject.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.util.Optional;

/**
 * In this class, a new trip service is created through the TripService builder, which through its methods
 * can import logged user's trips, search for a trip based on travel id, delete a trip based on travel id and
 * can save a new Trip object.
 */
@Service
public class TripService {

    @Autowired
    TripRepository tripRepo;

    public Iterable<Trip> getAllTrips() {
        return tripRepo.findAll();
    }

    public Trip saveTrip(Trip a) {
        return tripRepo.save(a);
    }

    public void savePhoto(MultipartFile imageFile) throws Exception{
        String folder=System.getProperty("user.dir")+ "/src/main/resources/static/photos";
        byte[] bytes=imageFile.getBytes();
        Path path=Paths.get(folder, imageFile.getOriginalFilename());
        Files.write(path,bytes);}


    public Trip getTrip(Long id) {
        return tripRepo.findById(id).orElse(null);
    }

    public void removeTripById(Long id) {
        tripRepo.deleteById(id);
    }

}




