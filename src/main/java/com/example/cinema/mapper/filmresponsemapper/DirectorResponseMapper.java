package com.example.cinema.mapper.filmresponsemapper;

import com.example.cinema.dto.filmresponsedto.DirectorResponseDTO;
import com.example.cinema.entity.filmdetail.Director;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DirectorResponseMapper {

    DirectorResponseDTO map(Director director);

    List<DirectorResponseDTO> map(List<Director> directors);

}
