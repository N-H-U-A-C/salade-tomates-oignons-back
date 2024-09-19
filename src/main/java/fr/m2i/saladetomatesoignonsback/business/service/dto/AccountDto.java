package fr.m2i.saladetomatesoignonsback.business.service.dto;

import java.util.List;
import java.util.UUID;

public record AccountDto(
        UUID id,
        String username,
        int defaultServing,
        String avatar,
        boolean admin,
        List<IngredientDto> ingredientsDto,
        List<AccountIngredientDto> accountIngredientsDto,
        List<AccountRecipeDto> accountRecipesDto
) {
}
