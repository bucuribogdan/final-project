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

    public Optional<Trip> getTrip(Long id) {
        return tripRepo.findById(id);
    }

    public void removeTripById(Long id) {
        tripRepo.deleteById(id);
    }

}




