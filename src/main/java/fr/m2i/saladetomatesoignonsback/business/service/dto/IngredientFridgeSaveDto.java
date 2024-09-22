package fr.m2i.saladetomatesoignonsback.business.service.dto;

import java.util.UUID;

public record IngredientFridgeSaveDto(
        UUID accountId,
        UUID ingredientId,
        int quantity
) {
}
