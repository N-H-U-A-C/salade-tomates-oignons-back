package fr.m2i.saladetomatesoignonsback.business.service.mapper;

import fr.m2i.saladetomatesoignonsback.business.domain.AccountRecipe;
import fr.m2i.saladetomatesoignonsback.business.service.dto.AccountRecipeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = RecipeMapper.class)
public interface AccountRecipeMapper {

    AccountRecipeMapper INSTANCE = Mappers.getMapper(AccountRecipeMapper.class);

    @Mapping(target = "recipeDto", source = "recipe")
    AccountRecipeDto toAccountRecipeDto(AccountRecipe accountRecipe);
}
