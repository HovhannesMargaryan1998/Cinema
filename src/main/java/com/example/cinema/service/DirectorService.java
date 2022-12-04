package com.example.cinema.service;

import com.example.cinema.dto.filmrequestdetaildto.DirectorRequestDTO;
import com.example.cinema.dto.filmresponsedetaildto.DirectorResponseDTO;
import com.example.cinema.entity.filmdetail.Director;
import com.example.cinema.mapper.filmrequestdetaillmapper.DirectorRequestMapper;
import com.example.cinema.mapper.filmresponsedetailmapper.DirectorResponseMapper;
import com.example.cinema.repository.DirectorRepository;
import com.example.cinema.util.CreatePictureUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorService {

    private final DirectorResponseMapper directorResponseMapper;

    private final DirectorRepository directorRepository;
    private final ActorService actorService;
    private final CreatePictureUtil createPictureUtil;

    private final DirectorRequestMapper directorRequestMapper;

    public void addDirector(DirectorRequestDTO directorRequestDTO, MultipartFile multipartFile) {
        Director director = directorRequestMapper.map(directorRequestDTO);
        if (!multipartFile.isEmpty() && multipartFile.getSize() > 0) {
            director.setPictureUrl(createPictureUtil.creatPicture(multipartFile));
        }
        director.setAge(actorService.calculateAge(director.getDateBorn()));
        directorRepository.save(director);
    }

    public Director findById(int id) {
      return directorRepository.findById(id).orElse(null);

    }

    public List<DirectorResponseDTO> findAllDirectors() {
        return directorResponseMapper.map(directorRepository.findAll()) ;
    }

}
