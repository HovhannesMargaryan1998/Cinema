package com.example.cinema.repository;

import com.example.cinema.entity.filmdetail.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findAllByUserId(int userId);

    List<Comment> findAllByFilm_id(int film_id);

}
