package fr.m2i.saladetomatesoignonsback.persistence;

import fr.m2i.saladetomatesoignonsback.business.domain.Ingredient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface IngredientRepository extends CrudRepository<Ingredient, UUID>, PagingAndSortingRepository<Ingredient, UUID> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Ingredient i where i.id = :id")
    int customDeleteById(UUID id);
}
