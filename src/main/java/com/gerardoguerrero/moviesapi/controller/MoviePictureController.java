package com.gerardoguerrero.moviesapi.controller;

import com.gerardoguerrero.moviesapi.service.MovieService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.gerardoguerrero.moviesapi.model.Movie;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/movies")
@Api(tags = "Movies Controller", description = "Movies Controller")
public class MoviePictureController {
    @Autowired
    private MovieService moviePictureService;

    @GetMapping
    public List<Movie> getAllMoviePictures() {
        return moviePictureService.getAllMovies();
    }

    @GetMapping("/{movieId}")
    public Movie getMovieById(@PathVariable Long movieId) {
        return moviePictureService.getMovieById(movieId);
    }

    //Vote can be 1 or -1
    @PostMapping("/{movieId}/{vote}")
    public Movie voteUpOrDownMovie(@PathVariable Long movieId, @PathVariable Integer vote) {
        return moviePictureService.voteUpOrDown(movieId, vote);
    }

    @GetMapping("/release/{releaseYear}")
    public List<Movie> getMoviePicturesByReleaseYear(@PathVariable Integer releaseYear) {
        return moviePictureService.findByReleaseYear(releaseYear);
    }

    @GetMapping("/release")
    public Map<Integer, List<Movie>> findAllGroupByReleaseYear() {
        return moviePictureService.getMoviesGroupedByReleaseYear();
    }

}