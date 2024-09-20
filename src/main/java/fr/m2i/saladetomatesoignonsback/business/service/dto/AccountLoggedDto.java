package fr.m2i.saladetomatesoignonsback.business.service.dto;

import java.util.UUID;

public record AccountLoggedDto(
        UUID id,
        String username,
        int defaultServing,
        String avatar,
        boolean admin,
        String token
) {
}
