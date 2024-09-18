package fr.m2i.saladetomatesoignonsback.business.service;

import fr.m2i.saladetomatesoignonsback.business.domain.Recipe;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.Optional;
import java.util.UUID;

public interface RecipeService {

    Slice<Recipe> getAll(Pageable pageable);

    Optional<Recipe> getById(UUID id);

    Recipe saveOrUpdate(Recipe recipe);

    int deleteById(UUID id);
}
