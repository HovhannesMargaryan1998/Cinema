package com.example.cinema.mapper.filmresponsedetailmapper;

import com.example.cinema.dto.filmresponsedetaildto.ActorResponseDTO;
import com.example.cinema.dto.filmresponsedetaildto.GenreResponseDTO;
import com.example.cinema.entity.filmdetail.Actor;
import com.example.cinema.entity.filmdetail.Genre;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreResponseMapper {

    GenreResponseDTO map(Genre genre);

    List<GenreResponseDTO> map(List<Genre> genres);

}
