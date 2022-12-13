package com.example.cinema.dto.filmrequestdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DirectorRequestDTO {

    @NotEmpty(message = "director's name can't be empty")
    private String name;
    @NotEmpty(message = "director's surname can't be empty")
    private String surname;
    private String country;
    @NotNull(message = "director's date born can't be empty")
    private LocalDate dateBorn;
    private LocalDate dateDied;
    private String pictureUrl;
    private String biography;

}
