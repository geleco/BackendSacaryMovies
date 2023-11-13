package com.scarymovies.controller;

import com.scarymovies.entity.Movie;
import com.scarymovies.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    // Método para buscar um filme específico pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id) {
        Optional<Movie> movie = movieService.getMovieById(id);
        return movie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Novo endpoint para atualizar o status de visualização de um filme
    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateMovieWatchedStatus(@PathVariable Long id, @RequestBody String status) {
        movieService.updateMovieWatchedStatus(id, status);
        return ResponseEntity.ok().build();
    }
}
