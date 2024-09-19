package fr.m2i.saladetomatesoignonsback.business.service.dto;

public record RecipeIngredientDto(
        double quantity,
        boolean consumed,
        IngredientDto ingredientDto
) {
}
