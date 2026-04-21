package com.hr.movieticket.bookings.dtos;

import java.util.List;

public class BookingRequest {
    private Long userId;
    private Long showId;
    private List<Long> seatIds;

    public Long getUserId() { return userId; }
    public Long getShowId() { return showId; }
    public List<Long> getSeatIds() { return seatIds; }
}