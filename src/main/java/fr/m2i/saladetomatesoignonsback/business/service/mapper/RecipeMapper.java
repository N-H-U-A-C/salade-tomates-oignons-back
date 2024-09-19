package fr.m2i.saladetomatesoignonsback.business.service.mapper;

import fr.m2i.saladetomatesoignonsback.business.domain.Recipe;
import fr.m2i.saladetomatesoignonsback.business.service.dto.RecipeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecipeMapper {

    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    RecipeDto toRecipeDto(Recipe recipe);
}
