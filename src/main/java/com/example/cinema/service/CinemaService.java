package com.example.cinema.service;

import com.example.cinema.entity.cinemadetail.Cinema;
import com.example.cinema.entity.cinemadetail.CinemaSeat;
import com.example.cinema.entity.filmdetail.Film;
import com.example.cinema.repository.CinemaRepository;
import com.example.cinema.repository.CinemaSeatRepository;
import com.example.cinema.util.CreatePictureUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CinemaService {

    private final CinemaRepository cinemaRepository;
    private final CreatePictureUtil createPictureUtil;
    private final FilmService filmService;
    private final CinemaSeatRepository cinemaSeatRepository;

    public void addCinema(Cinema cinema, MultipartFile multipartFile) {
        if (!multipartFile.isEmpty() && multipartFile.getSize() > 0) {
            cinema.setPictureUrl(createPictureUtil.creatPicture(multipartFile));
        }
        cinema.setSeats(createCinemaSeat(cinema.getSpaciousness()));
        cinemaRepository.save(cinema);
        log.info("add cinema{}", cinema.getName());
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

    private List<CinemaSeat> createCinemaSeat(int spaciousness){
        List<CinemaSeat> seats = new ArrayList<>();
        for (int i = 0; i < spaciousness; i++) {
            CinemaSeat cinemaSeat = CinemaSeat.builder()
                    .number(i)
                    .isOrdered(false)
                    .build();
            cinemaSeatRepository.save(cinemaSeat);
            seats.add(cinemaSeat);
        }
        return seats;
    }

    private List<Film> allFilmsById(List<Integer> filmsIds) {
        var films = new ArrayList<Film>();
        filmsIds.stream().filter(filmId -> filmId != 0).
                forEach(f -> films.add(filmService.getById(f)));
        return films;
    }

}
