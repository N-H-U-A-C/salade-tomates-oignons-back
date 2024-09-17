package fr.m2i.saladetomatesoignonsback.business.service;

import fr.m2i.saladetomatesoignonsback.business.domain.Animal;
import fr.m2i.saladetomatesoignonsback.business.service.dto.AnimalDto;
import fr.m2i.saladetomatesoignonsback.persistence.AnimalRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public Slice<AnimalDto> getAllAnimalDto(Pageable pageable) {
        return animalRepository.findAllAnimalDto(pageable);
    }

    @Override
    public Optional<AnimalDto> getAnimalDtoById(UUID id) {
        return animalRepository.findAnimalDtoById(id);
    }

    @Override
    public Animal saveOrUpdate(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public int deleteById(UUID id) {
        return animalRepository.customDeleteById(id);
    }
}
