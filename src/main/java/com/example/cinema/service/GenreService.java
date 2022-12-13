package com.example.cinema.service;

import com.example.cinema.entity.filmdetail.Genre;
import com.example.cinema.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;

    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }

    public Genre getById(int id) {
        return genreRepository.findById(id).orElse(null);
    }

}
