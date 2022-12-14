package com.example.cinema.mapper.userrequestmapper;

import com.example.cinema.dto.userrequestdto.UserRequestDTO;
import com.example.cinema.dto.userrequestdto.UserUpdateRequestDTO;
import com.example.cinema.dto.userresponsedto.UserResponseDTO;
import com.example.cinema.dto.userresponsedto.UserResponseDTO.UserResponseDTOBuilder;
import com.example.cinema.entity.filmdetail.Film;
import com.example.cinema.entity.userdetail.User;
import com.example.cinema.entity.userdetail.User.UserBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-15T14:09:26+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User map(UserRequestDTO userRegisterRequestDTO) {
        if ( userRegisterRequestDTO == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.name( userRegisterRequestDTO.getName() );
        user.surname( userRegisterRequestDTO.getSurname() );
        user.email( userRegisterRequestDTO.getEmail() );
        user.password( userRegisterRequestDTO.getPassword() );
        user.pictureUrl( userRegisterRequestDTO.getPictureUrl() );

        return user.build();
    }

    @Override
    public User map(UserUpdateRequestDTO userUpdateRequestDTO) {
        if ( userUpdateRequestDTO == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        if ( userUpdateRequestDTO.getName() != null ) {
            user.name( userUpdateRequestDTO.getName() );
        }
        if ( userUpdateRequestDTO.getSurname() != null ) {
            user.surname( userUpdateRequestDTO.getSurname() );
        }
        if ( userUpdateRequestDTO.getEmail() != null ) {
            user.email( userUpdateRequestDTO.getEmail() );
        }
        if ( userUpdateRequestDTO.getPassword() != null ) {
            user.password( userUpdateRequestDTO.getPassword() );
        }

        return user.build();
    }

    @Override
    public UserResponseDTO map(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDTOBuilder userResponseDTO = UserResponseDTO.builder();

        userResponseDTO.id( user.getId() );
        userResponseDTO.name( user.getName() );
        userResponseDTO.surname( user.getSurname() );
        userResponseDTO.email( user.getEmail() );
        List<Film> list = user.getFilms();
        if ( list != null ) {
            userResponseDTO.films( new ArrayList<Film>( list ) );
        }
        userResponseDTO.role( user.getRole() );
        userResponseDTO.pictureUrl( user.getPictureUrl() );
        userResponseDTO.registeredDate( user.getRegisteredDate() );

        return userResponseDTO.build();
    }
}
