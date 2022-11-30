package com.example.cinema.service.director;

import com.example.cinema.entity.filmDetail.Director;
import com.example.cinema.repository.DirectorRepository;
import com.example.cinema.service.actorservice.ActorService;
import com.example.cinema.util.CreatePictureUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    public List<Director> findAllDirectors() {
        return directorRepository.findAll();
    }

}
