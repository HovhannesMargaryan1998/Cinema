package com.example.cinema.Unit.service.userservice;

import com.example.cinema.entity.userDetail.User;
import com.example.cinema.repository.UserRepository;
import com.example.cinema.service.userservice.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private  PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    private User user = new User();

//    @Test
//    void save(){
//        when(userRepository.save(user).thenReturn(book)
//    }

}