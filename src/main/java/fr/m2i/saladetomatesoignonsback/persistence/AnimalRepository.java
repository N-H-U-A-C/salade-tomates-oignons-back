package fr.m2i.saladetomatesoignonsback.persistence;

import fr.m2i.saladetomatesoignonsback.business.domain.Animal;
import fr.m2i.saladetomatesoignonsback.business.service.dto.AnimalDto;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

public interface AnimalRepository extends CrudRepository<Animal, UUID>, PagingAndSortingRepository<Animal, UUID> {

    // constructor expression
    @Query("""
            SELECT new fr.m2i.saladetomatesoignonsback.business.service.dto.AnimalDto(
                a.id,
                a.label
            )
            FROM Animal a
            """)
    Slice<AnimalDto> findAllAnimalDto(Pageable pageable);

    // constructor expression
    @Query("""
            SELECT new fr.m2i.saladetomatesoignonsback.business.service.dto.AnimalDto(
                a.id,
                a.label
            )
            FROM Animal a WHERE a.id = :id
            """)
    Optional<AnimalDto> findAnimalDtoById(UUID id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Animal a where a.id = :id")
    int customDeleteById(UUID id);
}
