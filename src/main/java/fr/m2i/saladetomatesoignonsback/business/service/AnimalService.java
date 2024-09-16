package fr.m2i.saladetomatesoignonsback.business.service;

import fr.m2i.saladetomatesoignonsback.business.domain.Animal;
import fr.m2i.saladetomatesoignonsback.business.service.dto.AnimalDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface AnimalService {

    Slice<AnimalDto> getAllAnimalDto(Pageable pageable);
}
