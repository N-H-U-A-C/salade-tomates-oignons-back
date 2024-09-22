package fr.m2i.saladetomatesoignonsback.persistence;

import fr.m2i.saladetomatesoignonsback.business.domain.Recipe;
import fr.m2i.saladetomatesoignonsback.business.service.dto.RecipeShortDto;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RecipeRepository extends CrudRepository<Recipe, UUID>, PagingAndSortingRepository<Recipe, UUID> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Recipe r where r.id = :id")
    int customDeleteById(UUID id);

    // constructor expression
    @Query("""
            SELECT DISTINCT new fr.m2i.saladetomatesoignonsback.business.service.dto.RecipeShortDto(
                r.id,
                r.label,
                r.publicRecipe,
                r.instruction,
                r.duration,
                r.picture
            )
            FROM Recipe r
            JOIN r.recipeIngredients ri
            WHERE ri.ingredient.id IN (
                SELECT ai.ingredient.id FROM AccountIngredient ai
                WHERE ai.account.id = :accountId
                )
            """)
    Slice<RecipeShortDto> findAllDoableRecipesByAccountId(UUID accountId, Pageable pageable);
}
