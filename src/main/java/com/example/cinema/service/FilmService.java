package com.example.cinema.service;

import com.example.cinema.dto.filmrequestdetaildto.FilmRequestDTO;
import com.example.cinema.entity.filmdetail.*;
import com.example.cinema.entity.userdetail.User;
import com.example.cinema.mapper.filmrequestdetaillmapper.FilmRequestMapper;
import com.example.cinema.repository.CommentRepository;
import com.example.cinema.repository.FilmRepository;
import com.example.cinema.util.CreatePictureUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FilmService {

    private final FilmRepository filmRepository;

    private final ActorService actorService;

    private final DirectorService directorService;

    private final CreatePictureUtil createPictureUtil;
    private final FilmRequestMapper filmMapper;
    private final GenreService genreService;
    private final CommentRepository commentRepository;

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
        log.info("film added {}", film.getOriginalTitle());
    }

    public List<Film> getFiveFilmsByRating() {
        if (filmRepository.findFiveFilmsByRating().isEmpty()) {
            return null;
        }
        return filmRepository.findFiveFilmsByRating();
    }

    public int getCountAllFilms() {
        return filmRepository.countAllFilms();
    }

    public Page<Film> getAllFilms(Pageable pageable) {
        if (filmRepository.findAll().isEmpty()) {
            return null;
        }
        return filmRepository.findAll(pageable);
    }

    public Page<Film> getFilmsSortedByPremiere(Pageable pageable) {
        if (filmRepository.findFilmsSortedByPremiere(pageable).isEmpty()) {
            return null;
        }
        return filmRepository.findFilmsSortedByPremiere(pageable);
    }

    public Page<Film> getFilmsSortedByRating(Pageable pageable) {
        if (filmRepository.findFilmSortedByRating(pageable).isEmpty()) {
            return null;
        }
        return filmRepository.findFilmSortedByRating(pageable);
    }

    private List<Genre> allGenresById(List<Integer> genresIds) {
        var genres = new ArrayList<Genre>();
        genresIds.stream().filter(genreId -> genreId != 0).forEach(g -> {
            genres.add(genreService.getById(g));
        });
        return genres;
    }

    public List<Film> getLastFilms() {
        return filmRepository.findAll();
    }

    public Film getFilmById(int film_id) {
        return filmRepository.findById(film_id).orElse(null);
    }

    public List<Comment> getFilmComments(int film_id) {
        return commentRepository.findAllByFilm_id(film_id);
    }

    public Film saveComment(String text, User user, int film_id) {
        Optional<Film> filmOptional = filmRepository.findById(film_id);
        Comment comment = Comment.builder()
                .film(filmOptional.get())
                .user(user)
                .text(text)
                .build();
        commentRepository.save(comment);
        return filmOptional.get();
    }

    private List<Actor> allActorsById(List<Integer> actorsIds) {
        var actors = new ArrayList<Actor>();
        actorsIds.stream().filter(actorId -> actorId != 0).forEach(g -> {
            actors.add(actorService.getById(g));
        });
        return actors;
    }

    public Page<Film> getFilmByGenre(Genre genre, Pageable pageable) {
        return filmRepository.findAllByGenres(genre, pageable);
    }

    public List<Film> getFilmByPremiere(int minDate, int maxDate) {
        return filmRepository.findAllByPremiere_Year(minDate, maxDate);
    }

    public List<Film> getByRating() {
        return filmRepository.findAllByRating();
    }

    public boolean deleteFilmById(int id) {
        if (filmRepository.findById(id).isPresent()) {
            filmRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
