package com.example.cinema.entity.filmDetail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String country;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "born")
    private Date dateBorn;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "died")
    private Date dateDied;
    private int age;
    private String pictureUrl;
    private String biography;
}
