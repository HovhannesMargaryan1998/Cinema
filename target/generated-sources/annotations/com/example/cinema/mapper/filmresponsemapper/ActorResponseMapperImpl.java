package com.example.cinema.mapper.filmresponsemapper;

import com.example.cinema.dto.filmresponsedto.ActorResponseDTO;
import com.example.cinema.dto.filmresponsedto.ActorResponseDTO.ActorResponseDTOBuilder;
import com.example.cinema.entity.filmdetail.Actor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-13T17:38:24+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class ActorResponseMapperImpl implements ActorResponseMapper {

    @Override
    public ActorResponseDTO map(Actor actor) {
        if ( actor == null ) {
            return null;
        }

        ActorResponseDTOBuilder actorResponseDTO = ActorResponseDTO.builder();

        actorResponseDTO.id( actor.getId() );
        actorResponseDTO.name( actor.getName() );
        actorResponseDTO.surname( actor.getSurname() );
        actorResponseDTO.country( actor.getCountry() );
        actorResponseDTO.dateBorn( actor.getDateBorn() );
        actorResponseDTO.dateDied( actor.getDateDied() );
        actorResponseDTO.age( actor.getAge() );
        actorResponseDTO.pictureUrl( actor.getPictureUrl() );
        actorResponseDTO.biography( actor.getBiography() );

        return actorResponseDTO.build();
    }

    @Override
    public List<ActorResponseDTO> map(List<Actor> actors) {
        if ( actors == null ) {
            return null;
        }

        List<ActorResponseDTO> list = new ArrayList<ActorResponseDTO>( actors.size() );
        for ( Actor actor : actors ) {
            list.add( map( actor ) );
        }

        return list;
    }
}
