package fr.m2i.saladetomatesoignonsback.persistence;

import fr.m2i.saladetomatesoignonsback.business.domain.Recipe;
import jakarta.transaction.Transactional;
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
}
