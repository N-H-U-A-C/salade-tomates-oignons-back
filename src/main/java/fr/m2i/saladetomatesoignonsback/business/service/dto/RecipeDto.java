package fr.m2i.saladetomatesoignonsback.business.service.dto;

import java.util.List;
import java.util.UUID;

public record RecipeDto(
        UUID id,
        String label,
        boolean publicRecipe,
        String instruction,
        int duration,
        String picture,
        List<RecipeIngredientDto> recipeIngredientsDto
) {
}
