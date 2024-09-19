package fr.m2i.saladetomatesoignonsback.business.service.mapper;

import fr.m2i.saladetomatesoignonsback.business.domain.AccountIngredient;
import fr.m2i.saladetomatesoignonsback.business.service.dto.AccountIngredientDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountIngredientMapper {

    AccountIngredientMapper INSTANCE = Mappers.getMapper(AccountIngredientMapper.class);

    AccountIngredientDto toDto(AccountIngredient accountIngredient);
}
