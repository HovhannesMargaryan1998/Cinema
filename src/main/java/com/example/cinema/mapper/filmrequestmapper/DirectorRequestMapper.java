package com.example.cinema.mapper.filmrequestmapper;


import com.example.cinema.dto.filmrequestdto.DirectorRequestDTO;
import com.example.cinema.entity.filmdetail.Director;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DirectorRequestMapper {

    Director map(DirectorRequestDTO directorRequestDTO);

}
