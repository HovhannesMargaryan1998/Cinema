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
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String originalTitle;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date premiere;
    @Column(name = "duration_minute")
    private int durationMinute;
    private String country;
    private Double rating;
    private String videoUrl;
    private String pictureUrl;
    @Enumerated(value = EnumType.STRING)
    private Status status;

}
