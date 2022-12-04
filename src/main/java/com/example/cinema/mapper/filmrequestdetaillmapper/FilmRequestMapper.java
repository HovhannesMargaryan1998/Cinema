package com.example.cinema.mapper.filmrequestdetaillmapper;

import com.example.cinema.dto.filmrequestdetaildto.FilmRequestDTO;
import com.example.cinema.entity.filmdetail.Film;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FilmRequestMapper {

    Film map(FilmRequestDTO filmRequestDTO);



}
