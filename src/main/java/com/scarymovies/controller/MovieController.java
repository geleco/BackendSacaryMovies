package com.scarymovies.controller;

import com.scarymovies.entity.Movie;
import com.scarymovies.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // Método para buscar filmes pelo nome
    @GetMapping("/search")
    public List<Movie> searchMovie(@RequestParam String name) {
        return movieService.searchMovies(name);
    }

    // Método para retornar todos os filmes
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
}
