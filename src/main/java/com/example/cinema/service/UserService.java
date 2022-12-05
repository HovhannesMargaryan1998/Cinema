package com.example.cinema.service;

import com.example.cinema.dto.userrequestdetaildto.UserRequestDTO;
import com.example.cinema.entity.userdetail.Role;
import com.example.cinema.entity.userdetail.User;
import com.example.cinema.mapper.userrequestdetailmapper.UserRequestMapper;
import com.example.cinema.repository.UserRepository;
import com.example.cinema.util.CreatePictureUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final CreatePictureUtil creatPicture;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRequestMapper userRequestMapper;

    public void registerUser(UserRequestDTO userRegisterRequestDTO, MultipartFile multipartFile) {
        User user = userRequestMapper.map(userRegisterRequestDTO);
        if (!multipartFile.isEmpty() && multipartFile.getSize() > 0) {
            user.setPictureUrl(creatPicture.creatPicture(multipartFile));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setEnable(true);
        userRepository.save(user);
        log.info("user registered {}", user.getEmail());
    }

    public void update(int id, UserRequestDTO userRequestDto) {
        userRepository.findById(id).ifPresent(user -> {
            if (userRequestDto.getName() != null) {
                user.setName(userRequestDto.getName());
            }
            if (userRequestDto.getSurname() != null) {
                user.setSurname(userRequestDto.getSurname());
            }
            if (userRequestDto.getEmail() != null) {
                user.setEmail(userRequestDto.getEmail());
            }
            if (userRequestDto.getPassword() != null) {
                user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
            }
            user.setRole(Role.USER);
            user.setEnable(true);
            user.setId(id);
            userRepository.save(user);
        });

    }
}
