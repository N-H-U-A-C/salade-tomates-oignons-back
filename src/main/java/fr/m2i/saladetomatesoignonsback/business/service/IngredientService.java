package fr.m2i.saladetomatesoignonsback.business.service;

import fr.m2i.saladetomatesoignonsback.business.domain.Ingredient;
import fr.m2i.saladetomatesoignonsback.business.service.dto.IngredientDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.Optional;
import java.util.UUID;

public interface IngredientService {

    Slice<IngredientDto> getAllIngredientDto(Pageable pageable);

    Optional<IngredientDto> getIngredientDtoById(UUID id);

    Ingredient saveOrUpdate(Ingredient ingredient);

    int deleteById(UUID id);
}
