package com.hr.movieticket.bookings.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

import com.hr.movieticket.bookings.service.BookingService;
import com.hr.movieticket.bookings.dtos.BookingRequest;
import com.hr.movieticket.bookings.dtos.ConfirmRequest;
import com.hr.movieticket.bookings.entity.Booking;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/reserve")
    public Booking reserve(@RequestBody BookingRequest request) {
        return bookingService.reserveSeats(
                request.getUserId(),
                request.getShowId(),
                request.getSeatIds()
        );
    }

    @PostMapping("/confirm")
    public Booking confirm(@RequestBody ConfirmRequest request) {
        return bookingService.confirmBooking(
                request.getBookingId(),
                request.getSeatIds()
        );
    }
}
