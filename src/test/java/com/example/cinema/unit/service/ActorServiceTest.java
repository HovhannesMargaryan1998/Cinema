package com.example.cinema.unit.service;

import com.example.cinema.mapper.filmrequestdetaillmapper.ActorRequestMapper;
import com.example.cinema.mapper.filmresponsedetailmapper.ActorResponseMapper;
import com.example.cinema.repository.ActorRepository;
import com.example.cinema.service.ActorService;
import com.example.cinema.util.CreatePictureUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ActorServiceTest {
    @Mock
    private ActorResponseMapper actorResponseMapper;
    @Mock
    private ActorRequestMapper actorRequestMapper;
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private CreatePictureUtil createPictureUtil;
    @InjectMocks
    private ActorService actorService;

    @Test
    @DisplayName("successfully calculate age")
    void calculateAge() {
        int age = 24;

        int actualAge = actorService.calculateAge(LocalDate.now().minusYears(24));

        assertEquals(age, actualAge);
    }
}