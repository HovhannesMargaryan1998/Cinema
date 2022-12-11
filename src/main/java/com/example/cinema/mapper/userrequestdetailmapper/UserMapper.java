package com.example.cinema.mapper.userrequestdetailmapper;


import com.example.cinema.dto.userrequestdetaildto.UserRequestDTO;
import com.example.cinema.dto.userresponsedetaildto.UserResponseDTO;
import com.example.cinema.entity.userdetail.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User map(UserRequestDTO userRegisterRequestDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserResponseDTO map(User user);


}
