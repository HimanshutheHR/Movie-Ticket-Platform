package com.hr.movieticket.bookings.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Show {
    @Id
    private Long id;

    private Long movieId;
    private Long theatreId;
    private String city;

    private LocalDateTime startTime;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getMovieId() { return movieId; }
    public void setMovieId(Long movieId) { this.movieId = movieId; }

    public Long getTheatreId() { return theatreId; }
    public void setTheatreId(Long theatreId) { this.theatreId = theatreId; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
}
