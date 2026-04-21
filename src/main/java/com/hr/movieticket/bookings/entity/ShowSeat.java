package com.hr.movieticket.bookings.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

import com.hr.movieticket.bookings.enums.SeatStatus;

@Entity
@Table(name = "show_seat")
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long showId;
    private Long seatId;

    @Enumerated(EnumType.STRING)
    private SeatStatus status; // AVAILABLE, HELD, BOOKED

    private LocalDateTime holdExpiryTime;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getShowId() { return showId; }
    public void setShowId(Long showId) { this.showId = showId; }

    public Long getSeatId() { return seatId; }
    public void setSeatId(Long seatId) { this.seatId = seatId; }

    public SeatStatus getStatus() { return status; }
    public void setStatus(SeatStatus status) { this.status = status; }

    public LocalDateTime getHoldExpiryTime() { return holdExpiryTime; }
    public void setHoldExpiryTime(LocalDateTime holdExpiryTime) { this.holdExpiryTime = holdExpiryTime; }
}
