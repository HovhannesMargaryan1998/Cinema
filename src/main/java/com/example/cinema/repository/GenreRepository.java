package com.example.cinema.repository;

import com.example.cinema.entity.filmdetail.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
