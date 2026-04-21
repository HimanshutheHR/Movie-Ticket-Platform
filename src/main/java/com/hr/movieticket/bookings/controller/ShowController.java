package com.hr.movieticket.bookings.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.hr.movieticket.bookings.service.ShowService;
import com.hr.movieticket.bookings.entity.Show;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping
    public List<Show> getShows(
            @RequestParam String city,
            @RequestParam Long movieId) {

        return showService.getShows(city, movieId);
    }
}
