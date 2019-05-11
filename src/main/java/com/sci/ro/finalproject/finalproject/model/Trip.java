package com.sci.ro.finalproject.finalproject.model;

import com.sun.prism.Image;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name ="trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private long idProfile;

    @Size(min = 3, max = 30, message = "Cel putin 3 caractere")
    private String tripName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="datefrom")
    private LocalDate dateFrom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="dateto")
    private LocalDate dateTo;

    @Size(min = 25, max = 30000, message = "Cel putin 3 caractere")
    private String impressions;

    public void setIdProfile(long idProfile) {
        User user =new User();
        this.idProfile = user.getId();
    }

    public long getIdProfile() {
        return idProfile;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public void setImpressions(String impressions) {
        this.impressions = impressions;
    }

    public int getId() {
        return id;
    }

    public String getTripName() {
        return tripName;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public String getImpressions() {
        return impressions;
    }
}
