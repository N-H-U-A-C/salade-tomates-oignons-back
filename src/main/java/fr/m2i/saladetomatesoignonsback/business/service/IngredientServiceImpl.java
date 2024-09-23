package fr.m2i.saladetomatesoignonsback.business.service;

import fr.m2i.saladetomatesoignonsback.business.domain.Ingredient;
import fr.m2i.saladetomatesoignonsback.business.service.dto.IngredientDto;
import fr.m2i.saladetomatesoignonsback.business.service.dto.IngredientFridgeDto;
import fr.m2i.saladetomatesoignonsback.business.service.dto.IngredientFridgeSaveDto;
import fr.m2i.saladetomatesoignonsback.business.service.mapper.IngredientMapper;
import fr.m2i.saladetomatesoignonsback.persistence.IngredientRepository;
import org.springframework.data.domain.PageRequest;
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
    public Slice<IngredientDto> getAllIngredientDto(Pageable pageable) {
        return ingredientRepository.findAll(pageable).map(IngredientMapper.INSTANCE::toIngredientDto);
    }

    @Override
    public Slice<IngredientDto> getAllIngredientDtoByLabel(String label, Pageable pageable) {
        return ingredientRepository.findAllByLabelIsContainingIgnoreCase(label, pageable).map(IngredientMapper.INSTANCE::toIngredientDto);
    }

    @Override
    public Optional<IngredientDto> getIngredientDtoById(UUID id) {
        return ingredientRepository.findById(id).map(IngredientMapper.INSTANCE::toIngredientDto);
    }

    @Override
    public Ingredient saveOrUpdate(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public int deleteById(UUID id) {
        return ingredientRepository.customDeleteById(id);
    }

    @Override
    public Slice<IngredientFridgeDto> getFridgeIngredientByAccountId(UUID accountId, PageRequest pageRequest) {
        return ingredientRepository.findFridgeIngredientByAccountId(accountId, pageRequest);
    }

    @Override
    public int createFridgeIngredientByAccountId(IngredientFridgeSaveDto ingredientFridgeSaveDto) {
        return ingredientRepository.createFridgeIngredientByAccountId(ingredientFridgeSaveDto.accountId(), ingredientFridgeSaveDto.ingredientId(), ingredientFridgeSaveDto.quantity());
    }

    @Override
    public int deleteFridgeIngredientByAccountIdAndId(UUID accountId, UUID ingredientId) {
        return ingredientRepository.deleteFridgeIngredientByAccountIdAndId(accountId, ingredientId);
    }
}
