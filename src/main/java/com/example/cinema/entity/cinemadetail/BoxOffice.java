package com.example.cinema.entity.cinemadetail;

import com.example.cinema.entity.filmdetail.Film;
import com.example.cinema.entity.userdetail.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class BoxOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @DateTimeFormat(pattern = ("HH-mm-ss"))
    private LocalDate time;
    private double price;
    @ManyToOne
    private User user;
    @ManyToOne
    private Cinema cinema;
    @ManyToOne
    private Film film;
    private int seatingNumber;
    private LocalDate date;

}
