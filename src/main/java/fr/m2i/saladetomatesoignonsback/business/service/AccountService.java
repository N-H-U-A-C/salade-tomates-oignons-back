package fr.m2i.saladetomatesoignonsback.business.service;

import fr.m2i.saladetomatesoignonsback.business.domain.Account;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.Optional;
import java.util.UUID;

public interface AccountService {

    Slice<Account> getAll(Pageable pageable);

    Optional<Account> getById(UUID id);

    Account saveOrUpdate(Account account);

    int deleteById(UUID id);
}
