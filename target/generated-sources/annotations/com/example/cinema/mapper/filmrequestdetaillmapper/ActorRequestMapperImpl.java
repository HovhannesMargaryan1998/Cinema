package com.example.cinema.mapper.filmrequestdetaillmapper;

import com.example.cinema.dto.filmrequestdetaildto.ActorRequestDTO;
import com.example.cinema.entity.filmdetail.Actor;
import com.example.cinema.entity.filmdetail.Actor.ActorBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-07T22:05:52+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class ActorRequestMapperImpl implements ActorRequestMapper {

    @Override
    public Actor map(ActorRequestDTO actorRequestDTO) {
        if ( actorRequestDTO == null ) {
            return null;
        }

        ActorBuilder actor = Actor.builder();

        actor.name( actorRequestDTO.getName() );
        actor.surname( actorRequestDTO.getSurname() );
        actor.country( actorRequestDTO.getCountry() );
        actor.dateBorn( actorRequestDTO.getDateBorn() );
        actor.dateDied( actorRequestDTO.getDateDied() );
        actor.pictureUrl( actorRequestDTO.getPictureUrl() );
        actor.biography( actorRequestDTO.getBiography() );

        return actor.build();
    }
}
