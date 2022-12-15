package com.example.cinema.mapper.filmresponsemapper;

import com.example.cinema.dto.filmresponsedto.DirectorResponseDTO;
import com.example.cinema.dto.filmresponsedto.DirectorResponseDTO.DirectorResponseDTOBuilder;
import com.example.cinema.entity.filmdetail.Director;
import com.example.cinema.entity.filmdetail.Film;
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
public class DirectorResponseMapperImpl implements DirectorResponseMapper {

    @Override
    public DirectorResponseDTO map(Director director) {
        if ( director == null ) {
            return null;
        }

        DirectorResponseDTOBuilder directorResponseDTO = DirectorResponseDTO.builder();

        directorResponseDTO.id( director.getId() );
        directorResponseDTO.name( director.getName() );
        directorResponseDTO.surname( director.getSurname() );
        directorResponseDTO.country( director.getCountry() );
        directorResponseDTO.dateBorn( director.getDateBorn() );
        directorResponseDTO.dateDied( director.getDateDied() );
        directorResponseDTO.age( director.getAge() );
        directorResponseDTO.pictureUrl( director.getPictureUrl() );
        directorResponseDTO.biography( director.getBiography() );
        List<Film> list = director.getFilms();
        if ( list != null ) {
            directorResponseDTO.films( new ArrayList<Film>( list ) );
        }

        return directorResponseDTO.build();
    }

    @Override
    public List<DirectorResponseDTO> map(List<Director> directors) {
        if ( directors == null ) {
            return null;
        }

        List<DirectorResponseDTO> list = new ArrayList<DirectorResponseDTO>( directors.size() );
        for ( Director director : directors ) {
            list.add( map( director ) );
        }

        return list;
    }
}
