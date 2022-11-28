package com.example.cinema.service.userservice;

import com.example.cinema.dto.UserRequestDto;
import com.example.cinema.entity.userDetail.Role;
import com.example.cinema.entity.userDetail.User;
import com.example.cinema.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Value("${cinema.image}")
    private String folderPath;

    public void registerUser(User user, MultipartFile multipartFile)  {
        if (!multipartFile.isEmpty() && multipartFile.getSize() > 0) {
            user.setPictureUrl(createUserPicture(multipartFile));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setEnable(true);
        userRepository.save(user);
        log.info("user registered {}", user.getEmail());
    }

    public byte[] getUserImage(String fileName) {
        try {
            InputStream inputStream = new FileInputStream(folderPath + File.separator + fileName);
            return IOUtils.toByteArray(inputStream);
        }catch (IOException e){
            log.error("method getUserImage in UserService failed", e);
            return null;
        }
    }

    public boolean isPictureNotAllowedType(MultipartFile multipartFile) {
        if (!multipartFile.isEmpty() && multipartFile.getSize() > 0) {
            return multipartFile.getContentType() != null && !multipartFile.getContentType().contains("image");
        }
        return false;
    }

    private String createUserPicture(MultipartFile multipartFile) {
        String fileName = System.nanoTime() + "_" + multipartFile.getOriginalFilename();
        String fullName = folderPath + File.separator + fileName;
        File file = new File(fullName);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            log.error("method transferTo in UserService failed", e);
            return null;
        }
        return fileName;
    }
    public void update(int id, UserRequestDto userRequestDto) {
        userRepository.findById(id).ifPresent(user -> {
            if (userRequestDto.getName()!=null){
                user.setName(userRequestDto.getName());
            }
            if (userRequestDto.getSurname()!=null){
                user.setSurname(userRequestDto.getSurname());
            }
            if (userRequestDto.getEmail()!=null){
                user.setEmail(userRequestDto.getEmail());
            }
            if (userRequestDto.getPassword()!=null){
                user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
            }
            user.setRole(Role.USER);
            user.setEnable(true);
            user.setId(id);
            userRepository.save(user);
        });


    }


}
