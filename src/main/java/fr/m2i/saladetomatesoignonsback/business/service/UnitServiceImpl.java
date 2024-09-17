package fr.m2i.saladetomatesoignonsback.business.service;

import fr.m2i.saladetomatesoignonsback.business.domain.Unit;
import fr.m2i.saladetomatesoignonsback.business.service.dto.UnitDto;
import fr.m2i.saladetomatesoignonsback.persistence.UnitRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UnitServiceImpl implements UnitService {

    private final UnitRepository unitRepository;

    public UnitServiceImpl(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public Slice<UnitDto> getAllUnitDto(Pageable pageable) {
        return unitRepository.findAllUnitDto(pageable);
    }

    @Override
    public Optional<UnitDto> getUnitDtoById(UUID id) {
        return unitRepository.findUnitDtoById(id);
    }

    @Override
    public Unit saveOrUpdate(Unit unit) {
        return unitRepository.save(unit);
    }

    @Override
    public int deleteById(UUID id) {
        return unitRepository.customDeleteById(id);
    }
}
