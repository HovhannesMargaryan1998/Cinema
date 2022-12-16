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
public class ActorRequestDTO {

    @NotEmpty(message = "actor's name can't be empty")
    private String name;
    @NotEmpty(message = "actor's surname can't be empty")
    private String surname;
    private String country;
    @NotNull(message = "actor's date born can't be empty")
    private LocalDate dateBorn;
    private LocalDate dateDied;
    private String pictureUrl;
    private String biography;

}
