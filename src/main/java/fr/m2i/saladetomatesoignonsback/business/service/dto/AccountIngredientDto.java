package fr.m2i.saladetomatesoignonsback.business.service.dto;

import java.util.UUID;

public record AccountIngredientDto(
        int quantity,
        IngredientDto ingredient
) {
}
