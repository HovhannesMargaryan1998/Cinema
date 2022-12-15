package com.example.cinema.mapper.filmresponsemapper;

import com.example.cinema.dto.filmresponsedto.ActorResponseDTO;
import com.example.cinema.entity.filmdetail.Actor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorResponseMapper {

    ActorResponseDTO map(Actor actor);
    List<ActorResponseDTO> map(List<Actor> actors);

}
