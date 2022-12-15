package com.example.cinema.mapper.filmresponsemapper;

import com.example.cinema.dto.filmresponsedto.GenreResponseDTO;
import com.example.cinema.entity.filmdetail.Genre;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreResponseMapper {

    GenreResponseDTO map(Genre genre);

    List<GenreResponseDTO> map(List<Genre> genres);

}
