package com.hr.movieticket.bookings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.hr.movieticket.bookings.entity.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {

    List<Show> findByCityAndMovieId(String city, Long movieId);
}
