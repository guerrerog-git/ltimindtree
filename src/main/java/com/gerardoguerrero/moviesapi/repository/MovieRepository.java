package com.gerardoguerrero.moviesapi.repository;
import com.gerardoguerrero.moviesapi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m.releaseYear, m FROM Movie m")
    List<Object[]> findAllGroupByReleaseYear();

    default Map<Integer, List<Movie>> getMoviesGroupedByReleaseYear() {
        List<Object[]> results = findAllGroupByReleaseYear();
        Map<Integer, List<Movie>> moviesByYear = new HashMap<>();
        for (Object[] result : results) {
            Integer releaseYear = (Integer) result[0];
            Movie movie = (Movie) result[1];
            moviesByYear.computeIfAbsent(releaseYear, k -> new ArrayList<>()).add(movie);
        }
        return moviesByYear;
    }

    List<Movie> findByReleaseYear(Integer releaseYear);
}