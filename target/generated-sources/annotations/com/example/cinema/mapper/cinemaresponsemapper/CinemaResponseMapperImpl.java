package com.example.cinema.mapper.cinemaresponsemapper;

import com.example.cinema.dto.cinemaresponsedto.CinemaResponseDTO;
import com.example.cinema.dto.cinemaresponsedto.CinemaResponseDTO.CinemaResponseDTOBuilder;
import com.example.cinema.entity.cinemadetail.Cinema;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-15T14:09:25+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class CinemaResponseMapperImpl implements CinemaResponseMapper {

    @Override
    public CinemaResponseDTO map(Cinema cinema) {
        if ( cinema == null ) {
            return null;
        }

        CinemaResponseDTOBuilder cinemaResponseDTO = CinemaResponseDTO.builder();

        cinemaResponseDTO.id( cinema.getId() );
        cinemaResponseDTO.name( cinema.getName() );
        cinemaResponseDTO.address( cinema.getAddress() );
        cinemaResponseDTO.phoneNumber( cinema.getPhoneNumber() );
        cinemaResponseDTO.email( cinema.getEmail() );
        cinemaResponseDTO.spaciousness( cinema.getSpaciousness() );
        cinemaResponseDTO.pictureUrl( cinema.getPictureUrl() );
        cinemaResponseDTO.price( cinema.getPrice() );

        return cinemaResponseDTO.build();
    }

    @Override
    public List<CinemaResponseDTO> map(List<Cinema> cinemas) {
        if ( cinemas == null ) {
            return null;
        }

        List<CinemaResponseDTO> list = new ArrayList<CinemaResponseDTO>( cinemas.size() );
        for ( Cinema cinema : cinemas ) {
            list.add( map( cinema ) );
        }

        return list;
    }
}
