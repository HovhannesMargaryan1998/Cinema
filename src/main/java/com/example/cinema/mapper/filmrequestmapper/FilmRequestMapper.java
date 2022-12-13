package com.example.cinema.mapper.filmrequestmapper;

import com.example.cinema.dto.filmrequestdto.FilmRequestDTO;
import com.example.cinema.entity.filmdetail.Film;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FilmRequestMapper {

    Film map(FilmRequestDTO filmRequestDTO);

}
