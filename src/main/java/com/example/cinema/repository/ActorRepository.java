package com.example.cinema.repository;

import com.example.cinema.entity.filmDetail.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    List<Actor> findAll();

}
