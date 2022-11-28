package com.example.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUserDto {

    private String name;
    private String surname;
    private String email;
    private String password;
    private String pictureUrl;
}
