package com.example.cinema.mapper.filmresponsemapper;

import com.example.cinema.dto.filmresponsedto.GenreResponseDTO;
import com.example.cinema.dto.filmresponsedto.GenreResponseDTO.GenreResponseDTOBuilder;
import com.example.cinema.entity.filmdetail.Genre;
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
public class GenreResponseMapperImpl implements GenreResponseMapper {

    @Override
    public GenreResponseDTO map(Genre genre) {
        if ( genre == null ) {
            return null;
        }

        GenreResponseDTOBuilder genreResponseDTO = GenreResponseDTO.builder();

        genreResponseDTO.id( genre.getId() );
        genreResponseDTO.name( genre.getName() );

        return genreResponseDTO.build();
    }

    @Override
    public List<GenreResponseDTO> map(List<Genre> genres) {
        if ( genres == null ) {
            return null;
        }

        List<GenreResponseDTO> list = new ArrayList<GenreResponseDTO>( genres.size() );
        for ( Genre genre : genres ) {
            list.add( map( genre ) );
        }

        return list;
    }
}
