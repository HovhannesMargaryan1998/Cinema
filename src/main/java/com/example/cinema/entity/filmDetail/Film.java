package com.example.cinema.entity.filmDetail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "film")
public class Film {

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
    @Enumerated(value = EnumType.STRING)
    private Status status;
    @ManyToOne
    private Director director;
    @ManyToMany
    private List<Actor> actors;
    @ManyToMany
    private List<Genre> genres;
    private String ageLimit;


}
