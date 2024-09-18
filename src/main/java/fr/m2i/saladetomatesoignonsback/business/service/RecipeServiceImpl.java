package fr.m2i.saladetomatesoignonsback.business.service;

import fr.m2i.saladetomatesoignonsback.business.domain.Recipe;
import fr.m2i.saladetomatesoignonsback.persistence.RecipeRepository;
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
    public Slice<Recipe> getAll(Pageable pageable) {
        return recipeRepository.findAll(pageable);
    }

    @Override
    public Optional<Recipe> getById(UUID id) {
        return recipeRepository.findById(id);
    }

    @Override
    public Recipe saveOrUpdate(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public int deleteById(UUID id) {
        return recipeRepository.customDeleteById(id);
    }
}
