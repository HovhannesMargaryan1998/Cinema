package com.example.cinema.mapper.filmrequestdetaillmapper;

import com.example.cinema.dto.filmrequestdetaildto.FilmRequestDTO;
import com.example.cinema.entity.filmdetail.Film;
import com.example.cinema.entity.filmdetail.Film.FilmBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-11T13:46:48+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class FilmRequestMapperImpl implements FilmRequestMapper {

    @Override
    public Film map(FilmRequestDTO filmRequestDTO) {
        if ( filmRequestDTO == null ) {
            return null;
        }

        FilmBuilder film = Film.builder();

        film.originalTitle( filmRequestDTO.getOriginalTitle() );
        film.premiere( filmRequestDTO.getPremiere() );
        film.durationMinute( filmRequestDTO.getDurationMinute() );
        film.description( filmRequestDTO.getDescription() );
        film.country( filmRequestDTO.getCountry() );
        film.videoUrl( filmRequestDTO.getVideoUrl() );
        film.pictureUrl( filmRequestDTO.getPictureUrl() );
        film.ageLimit( filmRequestDTO.getAgeLimit() );

        return film.build();
    }
}
