package com.example.cinema.mapper.filmrequestmapper;

import com.example.cinema.dto.filmrequestdto.ActorRequestDTO;
import com.example.cinema.entity.filmdetail.Actor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActorRequestMapper {

    Actor map(ActorRequestDTO actorRequestDTO);

}
