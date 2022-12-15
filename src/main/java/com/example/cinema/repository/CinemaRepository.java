package com.example.cinema.repository;

import com.example.cinema.entity.cinemadetail.Cinema;
import com.example.cinema.entity.cinemadetail.CinemaSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Integer> {

}
