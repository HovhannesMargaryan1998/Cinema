package com.example.cinema.dto.cinemaresponsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CinemaSeatResponseDTO {

    private int id;
    private int number;
    private boolean isOrdered;

}
