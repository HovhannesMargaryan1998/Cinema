package com.example.cinema.unit.service;

import com.example.cinema.dto.userrequestdetaildto.UserRequestDTO;
import com.example.cinema.entity.userdetail.Role;
import com.example.cinema.entity.userdetail.User;
import com.example.cinema.mapper.userrequestdetailmapper.UserRequestMapper;
import com.example.cinema.repository.UserRepository;
import com.example.cinema.service.UserService;
import com.example.cinema.util.CreatePictureUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserRequestMapper userRequestMapper;

    @Mock
    private CreatePictureUtil createPictureUtil;
    @Mock
    private MultipartFile multipartFile;
    @InjectMocks
    private UserService userService;

    private UserRequestDTO userRequestDTO = UserRequestDTO.builder()
            .name("some-name")
            .surname("some-surname")
            .email("some@mail.com")
            .password("some-password")
            .isEnable(true)
            .pictureUrl("some-picture-name")
            .build();

    private User user = User.builder()
            .id(1)
            .name("some-name")
            .surname("some-surname")
            .email("some@gmailcom")
            .password("some-password")
            .role(Role.USER)
            .pictureUrl("some-picture-name")
            .isEnable(true)
            .token("some-token")
            .build();


    @Test
    @DisplayName("successfully save user")
    void registerUser() {
        String pictureName = "some-picture-name";
        String password = "some-password";

        when(userRequestMapper.map(userRequestDTO)).thenReturn(user);
        when(createPictureUtil.creatPicture(any())).thenReturn(pictureName);
        when(multipartFile.isEmpty()).thenReturn(false);
        when(multipartFile.getSize()).thenReturn(2L);
        when(passwordEncoder.encode(password)).thenReturn(password);
        when(userRepository.save(user)).thenReturn(user);

        userService.registerUser(userRequestDTO, multipartFile);
    }


}

