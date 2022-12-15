package com.example.cinema.mapper.cinemarequestmapper;

import com.example.cinema.dto.cinemarequestdto.CinemaRequestDTO;
import com.example.cinema.entity.cinemadetail.Cinema;
import com.example.cinema.entity.cinemadetail.Cinema.CinemaBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-15T14:09:26+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class CinemaRequestMapperImpl implements CinemaRequestMapper {

    @Override
    public Cinema map(CinemaRequestDTO cinemaRequestDTO) {
        if ( cinemaRequestDTO == null ) {
            return null;
        }

        CinemaBuilder cinema = Cinema.builder();

        cinema.name( cinemaRequestDTO.getName() );
        cinema.address( cinemaRequestDTO.getAddress() );
        cinema.phoneNumber( cinemaRequestDTO.getPhoneNumber() );
        cinema.email( cinemaRequestDTO.getEmail() );
        cinema.spaciousness( cinemaRequestDTO.getSpaciousness() );
        cinema.pictureUrl( cinemaRequestDTO.getPictureUrl() );
        cinema.price( cinemaRequestDTO.getPrice() );

        return cinema.build();
    }
}
