package com.example.cinema.service;

import com.example.cinema.entity.cinemadetail.CinemaSeat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaSeatService {

    private final CinemaService cinemaService;

    public List<CinemaSeat> getSeatsByCinemaId(int id){
        return cinemaService.getCinemaById(id).getSeats();
    }

}
