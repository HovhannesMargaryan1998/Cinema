package com.example.cinema.service;

import com.example.cinema.dto.filmrequestdetaildto.ActorRequestDTO;
import com.example.cinema.dto.filmresponsedetaildto.ActorResponseDTO;
import com.example.cinema.entity.filmdetail.Actor;
import com.example.cinema.mapper.filmrequestdetaillmapper.ActorRequestMapper;
import com.example.cinema.mapper.filmresponsedetailmapper.ActorResponseMapper;
import com.example.cinema.repository.ActorRepository;
import com.example.cinema.util.CreatePictureUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorResponseMapper actorResponseMapper;
    private final ActorRequestMapper actorRequestMapper;

    private final ActorRepository actorRepository;
    private final CreatePictureUtil createPictureUtil;

    public void addActor(ActorRequestDTO actorRequestDTO, MultipartFile multipartFile) {
        Actor actor = actorRequestMapper.map(actorRequestDTO);
        if (!multipartFile.isEmpty() && multipartFile.getSize() > 0) {
            actor.setPictureUrl(createPictureUtil.creatPicture(multipartFile));
        }
        actor.setAge(calculateAge(actor.getDateBorn()));
        actorRepository.save(actor);
    }

    public Actor getById(int id) {
        return actorRepository.findById(id).orElse(null);
    }

    public List<ActorResponseDTO> findAllActors() {
        return actorResponseMapper.map(actorRepository.findAll());
    }

    public int calculateAge(LocalDate localDate) {
        return LocalDate.now().getYear() - localDate.getYear();
    }
}
