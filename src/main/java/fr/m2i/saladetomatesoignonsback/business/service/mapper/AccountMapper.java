package fr.m2i.saladetomatesoignonsback.business.service.mapper;

import fr.m2i.saladetomatesoignonsback.business.domain.Account;
import fr.m2i.saladetomatesoignonsback.business.service.dto.AccountDto;
import fr.m2i.saladetomatesoignonsback.business.service.dto.AccountLoggedDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {IngredientMapper.class, AccountIngredientMapper.class, AccountRecipeMapper.class})
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mapping(target = "ingredientsDto", source = "ingredients")
    @Mapping(target = "accountIngredientsDto", source = "accountIngredients")
    @Mapping(target = "accountRecipesDto", source = "accountRecipes")
    AccountDto toAccountDto(Account account);

    @Mapping(target = "token", constant = "dummy")
    AccountLoggedDto toAccountLoggedDto(Account account);
}
