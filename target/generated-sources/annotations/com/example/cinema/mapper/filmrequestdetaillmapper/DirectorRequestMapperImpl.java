package com.example.cinema.mapper.filmrequestdetaillmapper;

import com.example.cinema.dto.filmrequestdetaildto.DirectorRequestDTO;
import com.example.cinema.entity.filmdetail.Director;
import com.example.cinema.entity.filmdetail.Director.DirectorBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-11T13:46:48+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class DirectorRequestMapperImpl implements DirectorRequestMapper {

    @Override
    public Director map(DirectorRequestDTO directorRequestDTO) {
        if ( directorRequestDTO == null ) {
            return null;
        }

        DirectorBuilder director = Director.builder();

        director.name( directorRequestDTO.getName() );
        director.surname( directorRequestDTO.getSurname() );
        director.country( directorRequestDTO.getCountry() );
        director.dateBorn( directorRequestDTO.getDateBorn() );
        director.dateDied( directorRequestDTO.getDateDied() );
        director.pictureUrl( directorRequestDTO.getPictureUrl() );
        director.biography( directorRequestDTO.getBiography() );

        return director.build();
    }
}
