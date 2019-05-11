package com.sci.ro.finalproject.finalproject.service;


import com.sci.ro.finalproject.finalproject.model.Trip;
import com.sci.ro.finalproject.finalproject.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
    public class TripService {
        @Autowired
        TripRepository tripRepo;

        public Iterable<Trip> getAllTrips(){
            return tripRepo.findAll();
        }

        public Trip saveTrip(Trip a){
            return tripRepo.save(a);
        }


        public Optional<Trip> getTrip(Integer id){
            return tripRepo.findById(id);
        }

    }

