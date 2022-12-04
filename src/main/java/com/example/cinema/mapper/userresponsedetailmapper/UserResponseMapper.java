package com.example.cinema.mapper.userresponsedetailmapper;

import com.example.cinema.dto.userresponsedetaildto.UserResponseDTO;
import com.example.cinema.entity.userdetail.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface UserResponseMapper {

    UserResponseDTO map(User user);

}
