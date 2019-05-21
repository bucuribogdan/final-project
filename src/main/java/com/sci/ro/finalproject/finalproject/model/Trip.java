package com.sci.ro.finalproject.finalproject.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name ="trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Size(min = 3, max = 30, message =
    @NotNull
    private String trip_name;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name="date_from")
    private LocalDate dateFrom;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name="date_to")
    private LocalDate dateTo;

    //    @Size(min = 25, max = 30000, message = "Cel putin 3 caractere")
    @Column(name="impressions")
    private String impressions;

    public String getTrip_name() {
        return trip_name;
    }

    public void setTrip_name(String trip_name) {
        this.trip_name = trip_name;
    }

    public void setId(Long id) {
        this.id = id;
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


    public Long getId() {
        return id;
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
