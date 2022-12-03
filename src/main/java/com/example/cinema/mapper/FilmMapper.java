package com.example.cinema.mapper;

import com.example.cinema.dto.FilmRequestDTO;
import com.example.cinema.entity.filmDetail.Film;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FilmMapper {

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Film map(FilmRequestDTO filmRequestDTO);

}
