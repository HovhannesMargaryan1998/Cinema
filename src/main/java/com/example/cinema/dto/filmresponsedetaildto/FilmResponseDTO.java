package com.example.cinema.dto.filmresponsedetaildto;

import com.example.cinema.entity.filmdetail.Actor;
import com.example.cinema.entity.filmdetail.Director;
import com.example.cinema.entity.filmdetail.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmResponseDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String originalTitle;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate premiere;
    @Column(name = "duration_minute")
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

}
