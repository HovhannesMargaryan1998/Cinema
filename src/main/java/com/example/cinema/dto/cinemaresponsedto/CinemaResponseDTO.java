package com.example.cinema.dto.cinemaresponsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CinemaResponseDTO {

    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private int spaciousness;
    private String pictureUrl;

}
