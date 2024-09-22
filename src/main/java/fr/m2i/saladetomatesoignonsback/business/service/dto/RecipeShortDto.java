package fr.m2i.saladetomatesoignonsback.business.service.dto;

import java.util.UUID;

public record RecipeShortDto(
        UUID id,
        String label,
        boolean publicRecipe,
        String instruction,
        int duration,
        String picture
) {
}
