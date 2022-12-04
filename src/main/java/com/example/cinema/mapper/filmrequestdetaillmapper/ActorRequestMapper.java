package com.example.cinema.mapper.filmrequestdetaillmapper;

import com.example.cinema.dto.filmrequestdetaildto.ActorRequestDTO;
import com.example.cinema.entity.filmdetail.Actor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActorRequestMapper {

    Actor map(ActorRequestDTO actorRequestDTO);



}
