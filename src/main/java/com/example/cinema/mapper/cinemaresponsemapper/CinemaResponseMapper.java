package com.example.cinema.mapper.cinemaresponsemapper;

import com.example.cinema.dto.cinemaresponsedto.CinemaResponseDTO;
import com.example.cinema.entity.cinemadetail.Cinema;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CinemaResponseMapper {

    CinemaResponseDTO map(Cinema cinema);
    List<CinemaResponseDTO> map(List<Cinema> cinemas);

}
