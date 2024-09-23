package fr.m2i.saladetomatesoignonsback.business.service;

import fr.m2i.saladetomatesoignonsback.business.domain.Ingredient;
import fr.m2i.saladetomatesoignonsback.business.service.dto.IngredientDto;
import fr.m2i.saladetomatesoignonsback.business.service.dto.IngredientFridgeDto;
import fr.m2i.saladetomatesoignonsback.business.service.dto.IngredientFridgeSaveDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.Optional;
import java.util.UUID;

public interface IngredientService {

    Slice<IngredientDto> getAllIngredientDto(Pageable pageable);

    Slice<IngredientDto> getAllIngredientDtoByLabel(String label, Pageable pageable);

    Optional<IngredientDto> getIngredientDtoById(UUID id);

    Ingredient saveOrUpdate(Ingredient ingredient);

    int deleteById(UUID id);

    Slice<IngredientFridgeDto> getFridgeIngredientByAccountId(UUID accountId, PageRequest pageRequest);

    int createFridgeIngredientByAccountId(IngredientFridgeSaveDto ingredientFridgeSaveDto);

    int deleteFridgeIngredientByAccountIdAndId(UUID accountId, UUID ingredientId);
}
