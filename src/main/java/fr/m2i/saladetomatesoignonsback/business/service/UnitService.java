package fr.m2i.saladetomatesoignonsback.business.service;

import fr.m2i.saladetomatesoignonsback.business.domain.Unit;
import fr.m2i.saladetomatesoignonsback.business.service.dto.UnitDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.Optional;
import java.util.UUID;

public interface UnitService {

    Slice<UnitDto> getAllUnitDto(Pageable pageable);

    Optional<UnitDto> getUnitDtoById(UUID id);

    Unit saveOrUpdate(Unit unit);

    int deleteById(UUID id);
}
