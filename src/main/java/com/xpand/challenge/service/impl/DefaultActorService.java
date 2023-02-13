package com.xpand.challenge.service.impl;

import com.xpand.challenge.dto.*;
import com.xpand.challenge.model.Actor;
import com.xpand.challenge.repository.ActorRepository;
import com.xpand.challenge.service.ActorService;
import com.xpand.challenge.validator.Validator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultActorService implements ActorService {

    private final ActorRepository actorRepository;
    private final Validator<ActorDTO> actorValidator;

    public DefaultActorService(ActorRepository actorRepository, Validator<ActorDTO> actorValidator) {
        this.actorRepository = actorRepository;
        this.actorValidator = actorValidator;
    }

    @Override
    public IdentifiableActorDTO createActor(ActorDTO actorDTO) {
        actorValidator.validate(actorDTO);
        Actor actor = ActorDTOMapper.fromActorDTO(actorDTO);
        return ActorDTOMapper.toActorDTO(actorRepository.save(actor));
    }

    @Override
    public IdentifiableActorDTO getActor(Long id) {
        return actorRepository.findById(id).map(ActorDTOMapper::toActorDTO).orElseThrow();
    }

    @Override
    public List<IdentifiableActorDTO> getActors() {
        return actorRepository.findAll().stream().map(ActorDTOMapper::toActorDTO).collect(Collectors.toList());
    }

    @Override
        public List<IdentifiableActorDTO> getActorsByMovieId(Long movieId) {
        return actorRepository.findAll().stream()
                .filter(actor -> actor.getMovies().stream()
                        .anyMatch(m-> Long.compare(m.getId(), movieId) == 0))
                .map(ActorDTOMapper::toActorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void updateActor(Long id, ActorDTO actorDTO) {
        actorRepository.findById(id).orElseThrow();
        actorValidator.validate(actorDTO);
        Actor actor = ActorDTOMapper.fromActorDTO(actorDTO);
        actor.setId(id);
        actorRepository.save(actor);
    }

    @Override
    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }
    
}
