package fr.m2i.saladetomatesoignonsback.business.service;

import fr.m2i.saladetomatesoignonsback.business.domain.Ingredient;
import fr.m2i.saladetomatesoignonsback.persistence.IngredientRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Slice<Ingredient> getAll(Pageable pageable) {
        return ingredientRepository.findAll(pageable);
    }

    @Override
    public Optional<Ingredient> getById(UUID id) {
        return ingredientRepository.findById(id);
    }

    @Override
    public Ingredient saveOrUpdate(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public int deleteById(UUID id) {
        return ingredientRepository.customDeleteById(id);
    }
}
