package com.example.cinema.dto.filmrequestdetaildto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DirectorRequestDTO {

    private String name;
    private String surname;
    private String country;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateBorn;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDied;
    private String pictureUrl;
    private String biography;


}
