package com.scarymovies.service;

import com.scarymovies.entity.Movie;
import com.scarymovies.repository.MovieRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Método para buscar filmes pelo nome
    public List<Movie> searchMovies(String name) {
        return movieRepository.findByNomeContainingIgnoreCase(name);
    }

    // Método para retornar todos os filmes
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
