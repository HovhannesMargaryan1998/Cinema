package com.example.cinema.mapper.filmrequestdetaillmapper;


import com.example.cinema.dto.filmrequestdetaildto.DirectorRequestDTO;
import com.example.cinema.entity.filmdetail.Director;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DirectorRequestMapper {

    Director map(DirectorRequestDTO directorRequestDTO);



}
