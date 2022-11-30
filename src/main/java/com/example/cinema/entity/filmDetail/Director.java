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
@Table(name = "director")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String country;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "born")
    private LocalDate dateBorn;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "died")
    private LocalDate dateDied;
    private int age;
    @Column(name = "picture_url")
    private String pictureUrl;
    private String biography;
    @OneToMany
    List<Film> films;

}
