package com.example.cinema.dto.filmresponsedetaildto;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActorResponseDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


}
