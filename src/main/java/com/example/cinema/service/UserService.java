package com.example.cinema.service;


import com.example.cinema.dto.userrequestdto.UserRequestDTO;
import com.example.cinema.dto.userrequestdetaildto.UserRequestDTO;
import com.example.cinema.dto.userrequestdetaildto.UserUpdateRequestDTO;
import com.example.cinema.entity.userdetail.Role;
import com.example.cinema.entity.userdetail.User;
import com.example.cinema.repository.UserRepository;
import com.example.cinema.util.CreatePictureUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final CreatePictureUtil creatPicture;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;


    public void registerUser(UserRequestDTO userRegisterRequestDTO, MultipartFile multipartFile) {
        User user = userMapper.map(userRegisterRequestDTO);
        if (!multipartFile.isEmpty() && multipartFile.getSize() > 0) {
            user.setPictureUrl(creatPicture.creatPicture(multipartFile));
        }
       user = User.builder()
               .password(passwordEncoder.encode(user.getPassword()))
               .role(Role.USER)
               .isEnable(true)
               .registeredDate(LocalDate.now())
               .build();
        userRepository.save(user);
        log.info("user registered {}", user.getEmail());
    }

    public boolean checkUniqueEmail(String email) {
        Optional<User> byEmail = userRepository.findByEmail(email);
        return byEmail.isPresent();
    }

    public void update(int id, UserUpdateRequestDTO userUpdateRequestDTO) {
        User map = userMapper.map(userUpdateRequestDTO);
        if (userUpdateRequestDTO.getPassword() != null) {
            map.setPassword(passwordEncoder.encode(userUpdateRequestDTO.getPassword()));
        }
        map.setRole(Role.USER);
        map.setEnable(true);
        map.setId(id);
        userMapper.map(userRepository.save(map));

    public Page<User> getAllUsers(Pageable pageable) {
        if (userRepository.findAll(pageable).isEmpty()) {
            return null;
        }
        return userRepository.findAll(pageable);
    }

    public int getCountAllUsers() {
        return userRepository.countAllUsers();
    }

    public List<User> getLastFiveUsers() {
        if (userRepository.findLastFiveUsers().isEmpty()) {
            return null;
        }
        return userRepository.findLastFiveUsers();
    }

    public boolean deleteUserById(int id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
