package com.example.cinema.mapper.cinemarequestmapper;

import com.example.cinema.dto.cinemarequestdto.BoxOfficeRequestDTO;
import com.example.cinema.entity.cinemadetail.BoxOffice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoxOfficeRequestMapper {

    BoxOffice map(BoxOfficeRequestDTO boxOfficeRequestDTO);

}
