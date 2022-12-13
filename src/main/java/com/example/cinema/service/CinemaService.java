package com.example.cinema.service;

import com.example.cinema.entity.cinemadetail.Cinema;
import com.example.cinema.entity.filmdetail.Film;
import com.example.cinema.repository.CinemaRepository;
import com.example.cinema.util.CreatePictureUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaService {

    private final CinemaRepository cinemaRepository;
    private final CreatePictureUtil createPictureUtil;
    private final FilmService filmService;

    public void addCinema(Cinema cinema, MultipartFile multipartFile) {
        if (!multipartFile.isEmpty() && multipartFile.getSize() > 0) {
            cinema.setPictureUrl(createPictureUtil.creatPicture(multipartFile));
        }
        cinemaRepository.save(cinema);
    }

    public void addFilmsInCinema(int cinemaId, List<Integer> filmsId){
        Cinema cinema = cinemaRepository.findById(cinemaId).get();
        List<Film> films = cinema.getFilms();
        films.addAll(allFilmsById(filmsId));
        cinema.setFilms(films);
        cinemaRepository.save(cinema);
    }

    public Cinema getCinemaById(int id){
        return cinemaRepository.findById(id).orElse(null);
    }

    public List<Cinema> getAllCinemas(){
        return cinemaRepository.findAll();
    }

    private List<Film> allFilmsById(List<Integer> filmsIds) {
        var films = new ArrayList<Film>();
        filmsIds.stream().filter(filmId -> filmId != 0).forEach(f -> {
            films.add(filmService.getById(f));
        });
        return films;
    }

}
