package com.scarymovies.service;

import com.scarymovies.entity.Movie;
import com.scarymovies.repository.MovieRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    // Método para buscar um filme específico pelo ID
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    // Novo método para atualizar o status de visualização de um filme
    public void updateMovieWatchedStatus(Long id, String status) {
        movieRepository.findById(id).ifPresent(movie -> {
            movie.setWatchedStatus(status);
            movieRepository.save(movie);
        });
    }
}
