package com.example.cinema.dto.filmresponsedto;

import com.example.cinema.entity.cinemadetail.TimeSince;
import com.example.cinema.entity.filmdetail.Actor;
import com.example.cinema.entity.filmdetail.Director;
import com.example.cinema.entity.filmdetail.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmResponseDTO {

    private int id;
    private String originalTitle;
    private LocalDate premiere;
    private int durationMinute;
    private String description;
    private String country;
    private Double rating;
    private String videoUrl;
    private String pictureUrl;
    private Director director;
    private List<Actor> actors;
    private List<Genre> genres;
    private String ageLimit;
    private List<TimeSince> times;

}
