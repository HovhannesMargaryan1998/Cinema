package com.example.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmRequestDTO {

    private String originalTitle;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate premiere;
    private int durationMinute;
    private String description;
    private String country;
    private Double rating;
    private String videoUrl;
    private String pictureUrl;
    private int directorId;
    private List<Integer> actorsId;
    private List<Integer> genresId;
    private String ageLimit;


}
