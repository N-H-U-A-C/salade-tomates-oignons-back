package fr.m2i.saladetomatesoignonsback.business.service;

import fr.m2i.saladetomatesoignonsback.business.domain.Animal;
import fr.m2i.saladetomatesoignonsback.persistence.AnimalRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.UUID;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AnimalServiceImplTest {

    @InjectMocks
    private AnimalServiceImpl classUnderTest;
    @Mock
    private AnimalRepository animalRepository;

    @Test
    void should_Call_FindAllAnimalDto_Of_AnimalRepository() {
        // given
        Pageable pageable = PageRequest.of(0, 20, Sort.Direction.ASC, "label");

        // when
        classUnderTest.getAllAnimalDto(pageable);

        // then
        verify(animalRepository).findAllAnimalDto(pageable);
    }

    @Test
    void should_Call_FindAnimalDtoById_Of_AnimalRepository() {
        // given
        UUID id = UUID.fromString("8adcb6de-5db4-42cf-8cf9-056d3b702969");

        // when
        classUnderTest.getAnimalDtoById(id);

        // then
        verify(animalRepository).findAnimalDtoById(id);
    }

    @Test
    void should_Call_SaveOrUpdate_Of_AnimalRepository() {
        // given
        Animal animal = new Animal("Gorille");

        // when
        classUnderTest.saveOrUpdate(animal);

        // then
        verify(animalRepository).save(animal);
    }
}
