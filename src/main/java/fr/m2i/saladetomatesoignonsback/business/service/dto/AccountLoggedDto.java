package fr.m2i.saladetomatesoignonsback.business.service.dto;

public record AccountLoggedDto(
        AccountDto accountDto,
        String token
) {
}
