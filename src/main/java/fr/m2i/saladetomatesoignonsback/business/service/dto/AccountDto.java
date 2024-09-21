package fr.m2i.saladetomatesoignonsback.business.service.dto;

import java.util.UUID;

public record AccountDto(
        UUID id,
        String username,
        int defaultServing,
        String avatar,
        boolean admin
) {
}
