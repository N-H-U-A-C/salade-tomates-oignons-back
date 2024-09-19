package fr.m2i.saladetomatesoignonsback.business.service.dto;

public record AccountRecipeDto(
        int rating,
        boolean favorite,
        RecipeDto recipeDto
) {
}
