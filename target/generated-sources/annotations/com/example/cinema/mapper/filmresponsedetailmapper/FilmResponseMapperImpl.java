package com.example.cinema.mapper.filmresponsedetailmapper;

import com.example.cinema.dto.filmresponsedetaildto.FilmResponseDTO;
import com.example.cinema.dto.filmresponsedetaildto.FilmResponseDTO.FilmResponseDTOBuilder;
import com.example.cinema.entity.filmdetail.Actor;
import com.example.cinema.entity.filmdetail.Film;
import com.example.cinema.entity.filmdetail.Genre;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-07T22:05:53+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class FilmResponseMapperImpl implements FilmResponseMapper {

    @Override
    public FilmResponseDTO map(Film film) {
        if ( film == null ) {
            return null;
        }

        FilmResponseDTOBuilder filmResponseDTO = FilmResponseDTO.builder();

        filmResponseDTO.id( film.getId() );
        filmResponseDTO.originalTitle( film.getOriginalTitle() );
        filmResponseDTO.premiere( film.getPremiere() );
        filmResponseDTO.durationMinute( film.getDurationMinute() );
        filmResponseDTO.description( film.getDescription() );
        filmResponseDTO.country( film.getCountry() );
        filmResponseDTO.rating( film.getRating() );
        filmResponseDTO.videoUrl( film.getVideoUrl() );
        filmResponseDTO.pictureUrl( film.getPictureUrl() );
        filmResponseDTO.director( film.getDirector() );
        List<Actor> list = film.getActors();
        if ( list != null ) {
            filmResponseDTO.actors( new ArrayList<Actor>( list ) );
        }
        List<Genre> list1 = film.getGenres();
        if ( list1 != null ) {
            filmResponseDTO.genres( new ArrayList<Genre>( list1 ) );
        }
        filmResponseDTO.ageLimit( film.getAgeLimit() );

        return filmResponseDTO.build();
    }

    @Override
    public List<FilmResponseDTO> map(List<Film> films) {
        if ( films == null ) {
            return null;
        }

        List<FilmResponseDTO> list = new ArrayList<FilmResponseDTO>( films.size() );
        for ( Film film : films ) {
            list.add( map( film ) );
        }

        return list;
    }
}
