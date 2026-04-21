package com.hr.movieticket.bookings.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import com.hr.movieticket.bookings.repository.ShowSeatRepository;
import com.hr.movieticket.bookings.repository.BookingRepository;
import com.hr.movieticket.bookings.entity.ShowSeat;
import com.hr.movieticket.bookings.entity.Booking;
import com.hr.movieticket.bookings.enums.SeatStatus;

@Service
public class BookingService {

    @Autowired
    private ShowSeatRepository showSeatRepo;

    @Autowired
    private BookingRepository bookingRepo;

    @Transactional
    public Booking reserveSeats(Long userId, Long showId, List<Long> seatIds) {

        List<ShowSeat> seats = showSeatRepo.findSeatsForUpdate(seatIds);

        for (ShowSeat seat : seats) {
            if (seat.getStatus() != SeatStatus.AVAILABLE) {
                throw new RuntimeException("Seat not available");
            }
        }

        LocalDateTime expiry = LocalDateTime.now().plusMinutes(5);

        for (ShowSeat seat : seats) {
            seat.setStatus(SeatStatus.HELD);
            seat.setHoldExpiryTime(expiry);
        }

        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setShowId(showId);
        booking.setStatus("RESERVED");

        return bookingRepo.save(booking);
    }


    @Transactional
    public Booking confirmBooking(Long bookingId, List<Long> seatIds) {

        List<ShowSeat> seats = showSeatRepo.findSeatsForUpdate(seatIds);

        for (ShowSeat seat : seats) {
            if (seat.getStatus() != SeatStatus.HELD ||
                    seat.getHoldExpiryTime().isBefore(LocalDateTime.now())) {
                throw new RuntimeException("Seat hold expired or invalid");
            }
        }

        for (ShowSeat seat : seats) {
            seat.setStatus(SeatStatus.BOOKED);
        }

        Booking booking = bookingRepo.findById(bookingId).orElseThrow();
        booking.setStatus("CONFIRMED");

        return bookingRepo.save(booking);
    }
}