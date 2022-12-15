package com.example.cinema.mapper.userrequestdetailmapper;


import com.example.cinema.dto.userrequestdto.UserRequestDTO;
import com.example.cinema.dto.userresponsedto.UserResponseDTO;
import com.example.cinema.entity.userdetail.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User map(UserRequestDTO userRegisterRequestDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    User map(UserUpdateRequestDTO userUpdateRequestDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserResponseDTO map(User user);


}
