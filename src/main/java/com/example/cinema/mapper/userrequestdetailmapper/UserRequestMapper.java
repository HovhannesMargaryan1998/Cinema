package com.example.cinema.mapper.userrequestdetailmapper;

import com.example.cinema.dto.userrequestdetaildto.UserRequestDTO;
import com.example.cinema.entity.userdetail.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface UserRequestMapper {

    User map(UserRequestDTO userRegisterRequestDTO);

}
