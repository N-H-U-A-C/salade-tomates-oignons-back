package fr.m2i.saladetomatesoignonsback.business.service.dto;

import java.util.UUID;

public record IngredientFridgeDto(
        UUID id,
        int quantity,
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
