package com.example.cinema.service;

import com.example.cinema.dto.UserRequestDto;
import com.example.cinema.entity.userDetail.Role;
import com.example.cinema.entity.userDetail.User;
import com.example.cinema.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Value("${cinema.image}")
    private String folderPath;


    public void registerUser(User user, MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty() && multipartFile.getSize() > 0) {
            user.setPictureUrl(createUserPicture(multipartFile));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setEnable(true);
        userRepository.save(user);
    }

    public byte[] getUserImage(String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(folderPath + File.separator + fileName);
        return IOUtils.toByteArray(inputStream);
    }

    public boolean isPictureExist(MultipartFile multipartFile) {
        if (!multipartFile.isEmpty() && multipartFile.getSize() > 0) {
            if (multipartFile.getContentType() != null && !multipartFile.getContentType().contains("image")) {
                return true;
            }
        }
        return false;
    }

    private String createUserPicture(MultipartFile multipartFile) throws IOException {
        String fileName = System.nanoTime() + "_" + multipartFile.getOriginalFilename();
        String fullName = folderPath + File.separator + fileName;
        File file = new File(fullName);
        multipartFile.transferTo(file);
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

    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }
}
