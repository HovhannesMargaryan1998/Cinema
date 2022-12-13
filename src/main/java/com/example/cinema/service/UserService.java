package com.example.cinema.service;


import com.example.cinema.dto.userrequestdto.UserRequestDTO;
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

    public void registerUser(User user, MultipartFile multipartFile) {
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
