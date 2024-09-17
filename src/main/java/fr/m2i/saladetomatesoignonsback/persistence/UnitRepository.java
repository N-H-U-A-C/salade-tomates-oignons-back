package fr.m2i.saladetomatesoignonsback.persistence;

import fr.m2i.saladetomatesoignonsback.business.domain.Unit;
import fr.m2i.saladetomatesoignonsback.business.service.dto.UnitDto;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

public interface UnitRepository extends CrudRepository<Unit, UUID>, PagingAndSortingRepository<Unit, UUID> {

    // constructor expression
    @Query("""
            SELECT new fr.m2i.saladetomatesoignonsback.business.service.dto.UnitDto(
                u.id,
                u.label
            )
            FROM Unit u
            """)
    Slice<UnitDto> findAllUnitDto(Pageable pageable);

    // constructor expression
    @Query("""
            SELECT new fr.m2i.saladetomatesoignonsback.business.service.dto.UnitDto(
                u.id,
                u.label
            )
            FROM Unit u WHERE u.id = :id
            """)
    Optional<UnitDto> findUnitDtoById(UUID id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Unit u where u.id = :id")
    int customDeleteById(UUID id);
}
