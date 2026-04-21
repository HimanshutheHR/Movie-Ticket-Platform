package com.hr.movieticket.bookings.dtos;

import java.util.List;

public class ConfirmRequest {
    private Long bookingId;
    private List<Long> seatIds;

    public Long getBookingId() { return bookingId; }
    public List<Long> getSeatIds() { return seatIds; }
}
