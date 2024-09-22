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
    Page<IngredientFridgeDto> findFridgeByAccountId(UUID accountId, Pageable pageable);
}
