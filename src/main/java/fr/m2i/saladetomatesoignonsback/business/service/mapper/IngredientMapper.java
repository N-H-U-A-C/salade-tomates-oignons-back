package fr.m2i.saladetomatesoignonsback.business.service.mapper;

import fr.m2i.saladetomatesoignonsback.business.domain.Ingredient;
import fr.m2i.saladetomatesoignonsback.business.service.dto.IngredientDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IngredientMapper {

    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);

    @Mapping(target = "animalId", source = "ingredient.animal.id")
    @Mapping(target = "animalLabel", source = "ingredient.animal.label")
    @Mapping(target = "unitId", source = "ingredient.unit.id")
    @Mapping(target = "unitLabel", source = "ingredient.unit.label")
    IngredientDto toDto(Ingredient ingredient);
}
