package fr.m2i.saladetomatesoignonsback.business.service;

import fr.m2i.saladetomatesoignonsback.business.domain.Recipe;
import fr.m2i.saladetomatesoignonsback.business.service.dto.RecipeDto;
import fr.m2i.saladetomatesoignonsback.business.service.dto.RecipeShortDto;
import fr.m2i.saladetomatesoignonsback.business.service.mapper.RecipeMapper;
import fr.m2i.saladetomatesoignonsback.persistence.RecipeRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Slice<RecipeDto> getAllRecipeDto(Pageable pageable) {
        return recipeRepository.findAll(pageable).map(RecipeMapper.INSTANCE::toRecipeDto);
    }

    @Override
    public Optional<RecipeDto> getRecipeDtoById(UUID id) {
        return recipeRepository.findById(id).map(RecipeMapper.INSTANCE::toRecipeDto);
    }

    @Override
    public Recipe saveOrUpdate(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public int deleteById(UUID id) {
        return recipeRepository.customDeleteById(id);
    }

    @Override
    public Slice<RecipeShortDto> getAllDoableRecipesByAccountId(UUID accountId, PageRequest pageRequest) {
        return recipeRepository.findAllDoableRecipesByAccountId(accountId, pageRequest);
    }
}
