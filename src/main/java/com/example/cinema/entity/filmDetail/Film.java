package com.example.cinema.entity.filmDetail;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
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
    @ToString.Exclude
    @Transient
    private List<Actor> actors;
    @ManyToMany
    @ToString.Exclude
    @Transient
    private List<Genre> genres;
    private String ageLimit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Film film = (Film) o;
        return  Objects.equals(id, film.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
