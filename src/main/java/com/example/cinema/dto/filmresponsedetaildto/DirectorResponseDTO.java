package com.example.cinema.dto.filmresponsedetaildto;

import com.example.cinema.entity.filmdetail.Film;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DirectorResponseDTO {


    private int id;
    private String name;
    private String surname;
    private String country;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateBorn;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDied;
    private int age;
    private String pictureUrl;
    private String biography;
    List<Film> films;


}
