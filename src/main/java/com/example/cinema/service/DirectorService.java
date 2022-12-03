package com.example.cinema.service;

import com.example.cinema.entity.filmDetail.Director;
import com.example.cinema.entity.filmDetail.Film;
import com.example.cinema.repository.DirectorRepository;
import com.example.cinema.service.ActorService;
import com.example.cinema.util.CreatePictureUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DirectorService {

    private final DirectorRepository directorRepository;

    private final ActorService actorService;

    private final CreatePictureUtil createPictureUtil;

    public void addDirector(Director director, MultipartFile multipartFile) {
        if (!multipartFile.isEmpty() && multipartFile.getSize() > 0) {
            director.setPictureUrl(createPictureUtil.creatPicture(multipartFile));
        }
        director.setAge(actorService.calculateAge(director.getDateBorn()));
        directorRepository.save(director);
    }

    public Director findById(int id) {
      return directorRepository.findById(id).orElse(null);

    }

    public List<Director> findAllDirectors() {
        return directorRepository.findAll();
    }

}
