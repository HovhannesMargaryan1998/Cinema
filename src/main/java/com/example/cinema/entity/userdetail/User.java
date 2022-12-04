package com.example.cinema.entity.userdetail;


import com.example.cinema.entity.filmdetail.Film;
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
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    @OneToMany
    private List<Film> films;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    private boolean isEnable;
    private String token;
    private String pictureUrl;


}