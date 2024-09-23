package fr.m2i.saladetomatesoignonsback.business.service;

import fr.m2i.saladetomatesoignonsback.business.domain.Account;
import fr.m2i.saladetomatesoignonsback.business.service.dto.AccountDto;
import fr.m2i.saladetomatesoignonsback.business.service.dto.AccountLogInDto;
import fr.m2i.saladetomatesoignonsback.business.service.dto.AccountLoggedDto;
import fr.m2i.saladetomatesoignonsback.business.service.mapper.AccountMapper;
import fr.m2i.saladetomatesoignonsback.persistence.AccountRepository;
import fr.m2i.saladetomatesoignonsback.utils.HashUtil;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Slice<AccountDto> getAccountDtoAll(Pageable pageable) {
        return accountRepository.findAll(pageable).map(AccountMapper.INSTANCE::toAccountDto);
    }

    @Override
    public Optional<AccountDto> getAccountDtoById(UUID id) {
        return accountRepository.findById(id).map(AccountMapper.INSTANCE::toAccountDto);
    }

    @Override
    public Account saveOrUpdate(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public int deleteById(UUID id) {
        return accountRepository.customDeleteById(id);
    }

    @Override
    public Optional<AccountLoggedDto> logIn(AccountLogInDto accountLogInDto) {
        String hash = HashUtil.toMd5(accountLogInDto.password());
        return accountRepository.findByUsernameAndPassword(accountLogInDto.username(), hash)
                .map(AccountMapper.INSTANCE::toAccountLoggedDto);
    }
}
