package ch.zhaw.CineSearch.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.zhaw.CineSearch.entity.Movie;
import ch.zhaw.CineSearch.entity.MovieRepository;

@Component
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    public Optional<Movie> listMovieByMovieName(String movieName) {
        return movieRepository.findByMovieName(movieName);
        } 
    }