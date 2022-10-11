package com.example.cinema.entity.filmDetail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class ActorFilm {

    @ManyToMany
    @Column(name = "actor_id")
    private List<Actor> actors;

    @ManyToMany
    @Column(name = "film_id")
    private List<Film> films;

}
