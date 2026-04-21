package com.hr.movieticket.bookings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hr.movieticket.bookings.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}