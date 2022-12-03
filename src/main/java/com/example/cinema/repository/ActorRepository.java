package com.example.cinema.repository;

import com.example.cinema.entity.filmDetail.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
