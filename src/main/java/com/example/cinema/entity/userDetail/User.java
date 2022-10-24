package com.example.cinema.entity.userDetail;

import com.example.cinema.entity.filmDetail.Film;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    @OneToMany
    private List<Film> film;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Role role;

}