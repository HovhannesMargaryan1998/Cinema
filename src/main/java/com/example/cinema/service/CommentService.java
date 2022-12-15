package com.example.cinema.service;

import com.example.cinema.entity.filmdetail.Comment;
import com.example.cinema.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> getCommentByUserId(int id) {
        return commentRepository.findAllByUserId(id);
    }
}
