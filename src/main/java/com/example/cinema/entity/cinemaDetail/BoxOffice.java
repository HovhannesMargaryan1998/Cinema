package com.example.cinema.entity.cinemaDetail;

import com.example.cinema.entity.filmDetail.Film;
import com.example.cinema.entity.userDetail.User;
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
public class BoxOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @DateTimeFormat(pattern = ("HH-MM-SS"))
    private Date time;
    private int duration_min;
    private String ageLimit;
    private double price;
    @ManyToOne
    private User user;
    @ManyToOne
    private Cinema cinema;
    @ManyToOne
    private Film film;

}
