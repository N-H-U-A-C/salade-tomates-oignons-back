package fr.m2i.saladetomatesoignonsback.persistence;

import fr.m2i.saladetomatesoignonsback.business.domain.Ingredient;
import fr.m2i.saladetomatesoignonsback.business.service.dto.IngredientFridgeDto;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

public interface IngredientRepository extends CrudRepository<Ingredient, UUID>, PagingAndSortingRepository<Ingredient, UUID> {

    Page<Ingredient> findAllByLabelIsContainingIgnoreCase(String label, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Ingredient i WHERE i.id = :id")
    int customDeleteById(UUID id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO add_fridge(account_id, ingredient_id, add_fridge_quantity) VALUES (:accountId, :ingredientId, :quantity)",
            nativeQuery = true)
    int saveFridgeIngredientByAccountId(UUID accountId, UUID ingredientId, int quantity);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM AccountIngredient ai WHERE ai.account.id = :accountId AND ai.ingredient.id = :ingredientId")
    int deleteFridgeIngredientByAccountIdAndId(UUID accountId, UUID ingredientId);

    // constructor expression
    @Query("""
            SELECT new fr.m2i.saladetomatesoignonsback.business.service.dto.IngredientFridgeDto(
                i.id,
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
            FROM Ingredient i
            LEFT JOIN i.animal a
            JOIN i.unit u
            JOIN i.accountIngredients ai
            WHERE ai.account.id = :accountId
            """)
    Page<IngredientFridgeDto> findFridgeIngredientByAccountId(UUID accountId, Pageable pageable);
}
