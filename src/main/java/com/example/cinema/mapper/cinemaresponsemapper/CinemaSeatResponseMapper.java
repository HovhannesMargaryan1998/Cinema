package com.example.cinema.mapper.cinemaresponsemapper;

import com.example.cinema.dto.cinemaresponsedto.CinemaSeatResponseDTO;
import com.example.cinema.entity.cinemadetail.CinemaSeat;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CinemaSeatResponseMapper {

    CinemaSeatResponseDTO map(CinemaSeat cinemaSeat);

    List<CinemaSeatResponseDTO> map(List<CinemaSeat> cinemaSeats);

}
