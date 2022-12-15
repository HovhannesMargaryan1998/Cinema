package com.example.cinema.dto.userresponsedto;

import com.example.cinema.entity.filmdetail.Film;
import com.example.cinema.entity.userdetail.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {

    private int id;
    private String name;
    private String surname;
    private String email;
    private List<Film> films;
    private Role role;
    private String pictureUrl;
    private LocalDate registeredDate;

}
