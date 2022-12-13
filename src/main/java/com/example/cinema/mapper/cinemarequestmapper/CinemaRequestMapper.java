package com.example.cinema.mapper.cinemarequestmapper;

import com.example.cinema.dto.cinemarequestdto.CinemaRequestDTO;
import com.example.cinema.entity.cinemadetail.Cinema;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CinemaRequestMapper {

    Cinema map(CinemaRequestDTO cinemaRequestDTO);

}
