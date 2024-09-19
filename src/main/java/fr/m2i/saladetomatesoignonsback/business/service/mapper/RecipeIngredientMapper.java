package fr.m2i.saladetomatesoignonsback.business.service.mapper;

import fr.m2i.saladetomatesoignonsback.business.domain.RecipeIngredient;
import fr.m2i.saladetomatesoignonsback.business.service.dto.RecipeIngredientDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = IngredientMapper.class)
public interface RecipeIngredientMapper {

    RecipeIngredientMapper INSTANCE = Mappers.getMapper(RecipeIngredientMapper.class);

    @Mapping(target = "ingredientDto", source = "ingredient")
    RecipeIngredientDto toRecipeIngredientDto(RecipeIngredient recipeIngredient);
}
