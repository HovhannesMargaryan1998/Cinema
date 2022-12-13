package com.example.cinema.dto.cinemaresponsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimeSinceDTO {

    private int id;
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime time;

}
