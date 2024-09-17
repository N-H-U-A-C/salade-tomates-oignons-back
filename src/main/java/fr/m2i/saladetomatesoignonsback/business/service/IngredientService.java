package fr.m2i.saladetomatesoignonsback.business.service;

import fr.m2i.saladetomatesoignonsback.business.domain.Ingredient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.Optional;
import java.util.UUID;

public interface IngredientService {

    Slice<Ingredient> getAll(Pageable pageable);

    Optional<Ingredient> getById(UUID id);

    Ingredient saveOrUpdate(Ingredient ingredient);

    int deleteById(UUID id);
}
