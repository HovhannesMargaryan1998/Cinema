package com.example.cinema.mapper.cinemaresponsemapper;

import com.example.cinema.dto.cinemaresponsedto.TimeSinceDTO;
import com.example.cinema.entity.cinemadetail.TimeSince;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TimeSinceResponseMapper {

    TimeSinceDTO map(TimeSince timeSince);
    List<TimeSinceDTO> map(List<TimeSince> timeSince);

}
