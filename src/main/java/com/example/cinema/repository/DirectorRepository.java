package com.example.cinema.repository;

import com.example.cinema.entity.filmDetail.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectorRepository extends JpaRepository<Director, Integer> {


}
