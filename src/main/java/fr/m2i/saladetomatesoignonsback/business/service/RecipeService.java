package fr.m2i.saladetomatesoignonsback.business.service;

import fr.m2i.saladetomatesoignonsback.business.domain.Recipe;
import fr.m2i.saladetomatesoignonsback.business.service.dto.RecipeDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.Optional;
import java.util.UUID;

public interface RecipeService {

    Slice<RecipeDto> getAllRecipeDto(Pageable pageable);

    Optional<RecipeDto> getRecipeDtoById(UUID id);

    Recipe saveOrUpdate(Recipe recipe);

    int deleteById(UUID id);
}
