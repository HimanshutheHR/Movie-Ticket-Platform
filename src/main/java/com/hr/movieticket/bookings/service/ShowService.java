package com.hr.movieticket.bookings.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.hr.movieticket.bookings.repository.ShowRepository;
import com.hr.movieticket.bookings.entity.Show;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public List<Show> getShows(String city, Long movieId) {
        return showRepository.findByCityAndMovieId(city, movieId);
    }
}
