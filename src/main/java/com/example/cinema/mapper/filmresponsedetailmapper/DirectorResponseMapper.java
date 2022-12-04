package com.example.cinema.mapper.filmresponsedetailmapper;

import com.example.cinema.dto.filmresponsedetaildto.ActorResponseDTO;
import com.example.cinema.dto.filmresponsedetaildto.DirectorResponseDTO;
import com.example.cinema.entity.filmdetail.Actor;
import com.example.cinema.entity.filmdetail.Director;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DirectorResponseMapper {

    DirectorResponseDTO map(Director director);

    List<DirectorResponseDTO> map(List<Director> directors);

}
