package fr.m2i.saladetomatesoignonsback.persistence;

import fr.m2i.saladetomatesoignonsback.business.domain.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface AccountRepository extends CrudRepository<Account, UUID>, PagingAndSortingRepository<Account, UUID> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Account a where a.id = :id")
    int customDeleteById(UUID id);

    @Query("FROM Account a LEFT JOIN a.ingredients i LEFT JOIN FETCH a.accountIngredients ai")
    Page<Account> customFindAll(Pageable pageable);
}
