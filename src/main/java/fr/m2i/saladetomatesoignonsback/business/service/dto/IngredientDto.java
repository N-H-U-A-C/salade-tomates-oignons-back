package fr.m2i.saladetomatesoignonsback.business.service.dto;

import java.util.UUID;

public record IngredientDto(
        UUID id,
        String label,
        boolean vegetarian,
        boolean vegan,
        boolean glutenFree,
        boolean lactoseFree,
        int calorie,
        UUID animalId,
        String animalLabel,
        UUID unitId,
        String unitLabel
) {
}
