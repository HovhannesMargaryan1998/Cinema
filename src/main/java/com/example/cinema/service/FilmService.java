package com.example.cinema.service;

import com.example.cinema.dto.FilmRequestDTO;
import com.example.cinema.entity.filmDetail.Actor;
import com.example.cinema.entity.filmDetail.Film;
import com.example.cinema.entity.filmDetail.Genre;
import com.example.cinema.entity.filmDetail.Status;
import com.example.cinema.mapper.FilmMapper;
import com.example.cinema.repository.FilmRepository;
import com.example.cinema.util.CreatePictureUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;

    private final ActorService actorService;

    private final DirectorService directorService;

    private final CreatePictureUtil createPictureUtil;
    private final FilmMapper filmMapper;
    private final GenreService genreService;

    public void addFilm(FilmRequestDTO filmRequestDTO, MultipartFile multipartFile) {
        Film film = filmMapper.map(filmRequestDTO);
        film.setStatus(Status.ONLINE);
        film.setDirector(directorService.findById(filmRequestDTO.getDirectorId()));
        film.setGenres(allGenresById(filmRequestDTO.getGenresId()));
        film.setActors(allActorsById(filmRequestDTO.getActorsId()));
        if (!multipartFile.isEmpty() && multipartFile.getSize() > 0) {
            film.setPictureUrl(createPictureUtil.creatPicture(multipartFile));
        }
        film.getDirector().getFilms().add(film);
        filmRepository.save(film);
    }

    private List<Genre> allGenresById(List<Integer> genresIds) {
        var genres = new ArrayList<Genre>();
        genresIds.stream().filter(genreId -> genreId != 0).forEach(g -> {
            genres.add(genreService.getById(g));
        });
        return genres;
    }

    private List<Actor> allActorsById(List<Integer> genresIds) {
        var actors = new ArrayList<Actor>();
        genresIds.stream().filter(actorId -> actorId != 0).forEach(g -> {
            actors.add(actorService.getById(g));
        });
        return actors;
    }

}
