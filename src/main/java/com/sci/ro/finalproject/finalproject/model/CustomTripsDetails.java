package com.sci.ro.finalproject.finalproject.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDate;
import java.util.Collection;

public class CustomTripsDetails extends Trip {

    private Long id;
    private String tripName;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String impressions;
    private String firstPhoto;
    private String secondPhoto;


    public CustomTripsDetails(Long id, String tripName,LocalDate dateFrom, LocalDate dateTo,String impressions,String firstPhoto,String secondPhoto,Collection<? extends GrantedAuthority> authorities)
    {
        this.id=id;
        this.tripName=tripName;
        this.dateFrom=dateFrom;
        this.dateTo=dateTo;
        this.impressions=impressions;
        this.firstPhoto=firstPhoto;
        this.secondPhoto=secondPhoto;
    }


    public String getFirstPhoto() {
        return firstPhoto;
    }


    public String getSecondPhoto() {
        return secondPhoto;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }


    public LocalDate getDateTo() {
        return dateTo;
    }


    public String getTripName() {
        return tripName;
    }

    public String getImpressions() {
        return impressions;
    }
}
