package com.example.cinema.dto.userresponsedetaildto;

import com.example.cinema.entity.filmdetail.Film;
import com.example.cinema.entity.userdetail.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @Enumerated(value = EnumType.STRING)
    private Role role;
    private boolean isEnable;
    private String token;
    private String pictureUrl;


}
