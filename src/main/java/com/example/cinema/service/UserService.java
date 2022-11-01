package com.example.cinema.service;

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

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Value("${cinema.image}")
    private String folderPath;

    public void registerUser(User user, MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty() && multipartFile.getSize() > 0) {
            String fileName = System.nanoTime() + "_" + multipartFile.getOriginalFilename();
            String fullName = folderPath + File.separator + fileName;
            File file = new File(fullName);
            multipartFile.transferTo(file);
            user.setPictureUrl(fileName);
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


}
