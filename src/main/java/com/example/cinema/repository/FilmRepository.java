package com.example.cinema.repository;

import com.example.cinema.entity.filmDetail.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}
