package com.gerardoguerrero.moviesapi.service;

import com.gerardoguerrero.moviesapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gerardoguerrero.moviesapi.model.Movie;

import java.util.List;
import java.util.Map;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Map<Integer, List<Movie>> getMoviesGroupedByReleaseYear(){ return movieRepository.getMoviesGroupedByReleaseYear(); }

    public List<Movie> findByReleaseYear(Integer releaseYear) { return movieRepository.findByReleaseYear(releaseYear); }

    public Movie voteUpOrDown(Long movieId, Integer vote) {
        Movie movie = getMovieById(movieId);
        if (movie != null) {
            movie.setVotes(movie.getVotes() + vote);  // vote can be +1 or -1
            movieRepository.save(movie);
        }
        return movie;
    }
}