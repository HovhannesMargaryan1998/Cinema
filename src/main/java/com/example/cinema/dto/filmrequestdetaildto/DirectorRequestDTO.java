package com.example.cinema.dto.filmrequestdetaildto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateBorn;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDied;
    private String pictureUrl;
    private String biography;


}
