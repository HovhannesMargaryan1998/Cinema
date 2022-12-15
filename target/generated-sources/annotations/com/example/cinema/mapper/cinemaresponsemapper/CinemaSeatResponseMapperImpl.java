package com.example.cinema.mapper.cinemaresponsemapper;

import com.example.cinema.dto.cinemaresponsedto.CinemaSeatResponseDTO;
import com.example.cinema.dto.cinemaresponsedto.CinemaSeatResponseDTO.CinemaSeatResponseDTOBuilder;
import com.example.cinema.entity.cinemadetail.CinemaSeat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-15T14:09:26+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class CinemaSeatResponseMapperImpl implements CinemaSeatResponseMapper {

    @Override
    public CinemaSeatResponseDTO map(CinemaSeat cinemaSeat) {
        if ( cinemaSeat == null ) {
            return null;
        }

        CinemaSeatResponseDTOBuilder cinemaSeatResponseDTO = CinemaSeatResponseDTO.builder();

        cinemaSeatResponseDTO.id( cinemaSeat.getId() );
        cinemaSeatResponseDTO.number( cinemaSeat.getNumber() );

        return cinemaSeatResponseDTO.build();
    }

    @Override
    public List<CinemaSeatResponseDTO> map(List<CinemaSeat> cinemaSeats) {
        if ( cinemaSeats == null ) {
            return null;
        }

        List<CinemaSeatResponseDTO> list = new ArrayList<CinemaSeatResponseDTO>( cinemaSeats.size() );
        for ( CinemaSeat cinemaSeat : cinemaSeats ) {
            list.add( map( cinemaSeat ) );
        }

        return list;
    }
}
