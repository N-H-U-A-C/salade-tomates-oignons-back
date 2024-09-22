package fr.m2i.saladetomatesoignonsback.persistence;

import fr.m2i.saladetomatesoignonsback.business.domain.Ingredient;
import fr.m2i.saladetomatesoignonsback.business.service.dto.IngredientDto;
import fr.m2i.saladetomatesoignonsback.business.service.dto.IngredientFridgeDto;
import jakarta.persistence.criteria.From;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface IngredientRepository extends CrudRepository<Ingredient, UUID>, PagingAndSortingRepository<Ingredient, UUID> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Ingredient i where i.id = :id")
    int customDeleteById(UUID id);

    // constructor expression
    @Query("""
            SELECT new fr.m2i.saladetomatesoignonsback.business.service.dto.IngredientFridgeDto(
                ai.ingredient.id,
                ai.quantity,
                i.label,
                i.vegetarian,
                i.vegan,
                i.glutenFree,
                i.lactoseFree,
                i.calorie,
                a.id,
                a.label,
                u.id,
                u.label
            )
            FROM AccountIngredient ai
            JOIN Ingredient i ON ai.ingredient.id = i.id
            LEFT JOIN Animal a ON i.animal.id = a.id
            JOIN Unit u ON i.unit.id = u.id
            WHERE ai.account.id = :accountId
            """)
    Page<IngredientFridgeDto> findFridgeByAccountId(UUID accountId, Pageable pageable);
}
