package com.example.cinema.mapper.filmresponsemapper;

import com.example.cinema.dto.filmresponsedto.FilmResponseDTO;
import com.example.cinema.entity.filmdetail.Film;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FilmResponseMapper {

    FilmResponseDTO map(Film film);

    List<FilmResponseDTO> map(List<Film> films);
}
