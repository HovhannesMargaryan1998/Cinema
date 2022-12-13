package com.example.cinema.mapper.cinemaresponsemapper;

import com.example.cinema.dto.cinemaresponsedto.TimeSinceDTO;
import com.example.cinema.dto.cinemaresponsedto.TimeSinceDTO.TimeSinceDTOBuilder;
import com.example.cinema.entity.cinemadetail.TimeSince;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-13T17:38:25+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class TimeSinceResponseMapperImpl implements TimeSinceResponseMapper {

    @Override
    public TimeSinceDTO map(TimeSince timeSince) {
        if ( timeSince == null ) {
            return null;
        }

        TimeSinceDTOBuilder timeSinceDTO = TimeSinceDTO.builder();

        timeSinceDTO.id( timeSince.getId() );
        timeSinceDTO.time( timeSince.getTime() );

        return timeSinceDTO.build();
    }

    @Override
    public List<TimeSinceDTO> map(List<TimeSince> timeSince) {
        if ( timeSince == null ) {
            return null;
        }

        List<TimeSinceDTO> list = new ArrayList<TimeSinceDTO>( timeSince.size() );
        for ( TimeSince timeSince1 : timeSince ) {
            list.add( map( timeSince1 ) );
        }

        return list;
    }
}
