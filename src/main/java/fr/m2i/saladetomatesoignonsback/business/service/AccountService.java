package fr.m2i.saladetomatesoignonsback.business.service;

import fr.m2i.saladetomatesoignonsback.business.domain.Account;
import fr.m2i.saladetomatesoignonsback.business.service.dto.AccountDto;
import fr.m2i.saladetomatesoignonsback.business.service.dto.AccountLogInDto;
import fr.m2i.saladetomatesoignonsback.business.service.dto.AccountLoggedDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.Optional;
import java.util.UUID;

public interface AccountService {

    Slice<AccountDto> getAccountDtoAll(Pageable pageable);

    Optional<AccountDto> getAccountDtoById(UUID id);

    Account saveOrUpdate(Account account);

    int deleteById(UUID id);

    Optional<AccountLoggedDto> logIn(AccountLogInDto accountLogInDto);
}
