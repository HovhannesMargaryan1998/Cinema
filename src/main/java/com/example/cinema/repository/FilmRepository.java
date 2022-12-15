package com.example.cinema.repository;

import com.example.cinema.entity.filmdetail.Film;
import com.example.cinema.entity.filmdetail.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Integer> {

    Page<Film> findAllByGenres(Genre genre, Pageable pageable);



    @Query(value = "select * from film where (YEAR(premiere)) between :minDate  and :maxDate",nativeQuery = true)
    List<Film> findAllByPremiere_Year(int minDate,int maxDate);

    @Query(value =  "select * from film order by rating desc",nativeQuery = true)
    List<Film>findAllByRating();
    @Override
    Optional<Film> findById(Integer integer);

    List<Film> findAll();

    void deleteById(int id);

    @Query(value = "SELECT COUNT(id) FROM film", nativeQuery = true)
    int countAllFilms();

    @Query(value = "SELECT * FROM film where status = 'IN_CINEMA'", nativeQuery = true)
    List<Film> findOnlyCinemaFilms();

    @Query(value = "SELECT * FROM film ORDER BY rating DESC LIMIT 5", nativeQuery = true)
    List<Film> findFiveFilmsByRating();

    @Query(value = "SELECT * FROM film ORDER BY premiere DESC", nativeQuery = true)
    Page<Film> findFilmsSortedByPremiere(Pageable pageable);

    @Query(value = "SELECT * FROM film ORDER BY rating DESC", nativeQuery = true)
    Page<Film> findFilmSortedByRating(Pageable pageable);

}
