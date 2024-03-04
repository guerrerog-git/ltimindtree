package com.gerardoguerrero.moviesapi;

import com.gerardoguerrero.moviesapi.controller.MoviePictureController;
import com.gerardoguerrero.moviesapi.service.MovieService;
import com.gerardoguerrero.moviesapi.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MovieControllerTest {

    @Mock
    private MovieService moviePictureService;

    @InjectMocks
    private MoviePictureController movieController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
    }

    @Test
    public void testGetAllMoviePictures() throws Exception {
        List<Movie> movies = Arrays.asList(new Movie(1L, "Movie 1", 2023, "", 1 ),
                                           new Movie(2L, "Movie 2", 2022, "", 1 ));
        when(moviePictureService.getAllMovies()).thenReturn(movies);

        mockMvc.perform(get("/api/movies")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Movie 1"))
                .andExpect(jsonPath("$[1].title").value("Movie 2"));

        verify(moviePictureService, times(1)).getAllMovies();
        verifyNoMoreInteractions(moviePictureService);
    }

    @Test
    public void testGetMovieById() throws Exception {
        Movie movie = new Movie(1L, "Movie 1", 2023, "", 1 );
        when(moviePictureService.getMovieById(1L)).thenReturn(movie);

        mockMvc.perform(get("/api/movies/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Movie 1"));

        verify(moviePictureService, times(1)).getMovieById(1L);
        verifyNoMoreInteractions(moviePictureService);
    }

    @Test
    public void testGetMoviePicturesByReleaseYear() throws Exception {
        List<Movie> movies = Arrays.asList(new Movie(1L, "Movie 1", 2022, "", 1 ),
                new Movie(2L, "Movie 2", 2022, "", 1 ));
        when(moviePictureService.findByReleaseYear(2022)).thenReturn(movies);

        mockMvc.perform(get("/api/movies/release/2022")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Movie 1"))
                .andExpect(jsonPath("$[1].title").value("Movie 2"));

        verify(moviePictureService, times(1)).findByReleaseYear(2022);
        verifyNoMoreInteractions(moviePictureService);
    }

    @Test
    public void findAllGroupByReleaseYear() throws Exception {
        Map<Integer, List<Movie>> map = new HashMap<>();
        List<Movie> movies2022 = Arrays.asList(new Movie(1L, "Movie 1", 2022, "", 1 ),
                new Movie(2L, "Movie 2", 2022, "", 1 ));
        map.put(2022, movies2022);
        List<Movie> movies2023 = Arrays.asList(new Movie(1L, "Movie 3", 2023, "", 1 ),
                new Movie(2L, "Movie 4", 2023, "", 1 ));
        map.put(2023, movies2023);
        when(moviePictureService.getMoviesGroupedByReleaseYear()).thenReturn(map);

        mockMvc.perform(get("/api/movies/release")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.2022[0].title").value("Movie 1"))
                .andExpect(jsonPath("$.2022[1].title").value("Movie 2"))
                .andExpect(jsonPath("$.2023[0].title").value("Movie 3"))
                .andExpect(jsonPath("$.2023[1].title").value("Movie 4"));

        verify(moviePictureService, times(1)).getMoviesGroupedByReleaseYear();
        verifyNoMoreInteractions(moviePictureService);
    }

    @Test
    public void testVoteUpOrDownMovie() throws Exception {
        Long movieId = 1L;
        Integer vote = 1;
        Movie movie = new Movie(1L, "Movie 1", 2022, "", 2 );
        when(moviePictureService.voteUpOrDown(movieId, vote)).thenReturn(movie);

        mockMvc.perform(post("/api/movies/{movieId}/{vote}", movieId, vote)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("Movie 1"))
                .andExpect(jsonPath("$.releaseYear").value(2022))
                .andExpect(jsonPath("$.votes").value(2));

        verify(moviePictureService, times(1)).voteUpOrDown(movieId, vote);
        verifyNoMoreInteractions(moviePictureService);
    }

}