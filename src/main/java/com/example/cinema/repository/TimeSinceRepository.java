package com.example.cinema.repository;

import com.example.cinema.entity.cinemadetail.TimeSince;
import com.example.cinema.entity.filmdetail.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSinceRepository extends JpaRepository<TimeSince, Integer> {
}
