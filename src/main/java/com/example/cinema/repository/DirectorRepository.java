package com.example.cinema.repository;

import com.example.cinema.entity.filmdetail.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Integer> {

}
