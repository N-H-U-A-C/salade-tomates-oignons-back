package fr.m2i.saladetomatesoignonsback.business.service;

import fr.m2i.saladetomatesoignonsback.business.domain.Animal;
import fr.m2i.saladetomatesoignonsback.business.service.dto.AnimalDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.Optional;
import java.util.UUID;

public interface AnimalService {

    Slice<AnimalDto> getAllAnimalDto(Pageable pageable);

    Optional<AnimalDto> getAnimalDtoById(UUID id);

    Animal saveOrUpdate(Animal animal);
}
