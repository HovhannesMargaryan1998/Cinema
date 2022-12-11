package com.example.cinema.mapper.filmresponsedetailmapper;

import com.example.cinema.dto.filmresponsedetaildto.FilmResponseDTO;
import com.example.cinema.entity.filmdetail.Film;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FilmResponseMapper {

    FilmResponseDTO map(Film film);

    List<FilmResponseDTO> map(List<Film> films);
}
