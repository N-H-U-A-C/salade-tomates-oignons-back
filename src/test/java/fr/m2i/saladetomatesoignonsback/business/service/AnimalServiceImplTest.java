package fr.m2i.saladetomatesoignonsback.business.service;

import fr.m2i.saladetomatesoignonsback.repository.AnimalRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AnimalServiceImplTest {

    @InjectMocks
    private AnimalServiceImpl classUnderTest;
    @Mock
    private AnimalRepository animalRepository;

    @Test
    void getAllAnimalDto() {
        // given
        Pageable pageable = PageRequest.of(0, 20, Sort.Direction.ASC, "label");

        // when
        classUnderTest.getAllAnimalDto(pageable);

        // then
        verify(animalRepository).findAllAnimalDto(pageable);
    }
}
