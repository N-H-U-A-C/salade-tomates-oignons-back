package fr.m2i.saladetomatesoignonsback.controller;

import fr.m2i.saladetomatesoignonsback.business.domain.Account;
import fr.m2i.saladetomatesoignonsback.business.service.AccountService;
import fr.m2i.saladetomatesoignonsback.business.service.dto.AccountDto;
import fr.m2i.saladetomatesoignonsback.business.service.dto.AccountLogInDto;
import fr.m2i.saladetomatesoignonsback.business.service.dto.AccountLoggedDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;
import java.util.UUID;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping()
    public ResponseEntity<Slice<AccountDto>> getAccountDtoAll(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                pageable.getSortOr(Sort.by(Sort.Direction.ASC, "username"))
        );
        Slice<AccountDto> slice = accountService.getAccountDtoAll(pageRequest);
        return ResponseEntity.ok(slice);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountDtoById(@PathVariable UUID id) {
        Optional<AccountDto> optionalAccountDto = accountService.getAccountDtoById(id);
        return optionalAccountDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Void> save(@RequestBody Account account) {
        Account savedAccount = accountService.saveOrUpdate(account);
        // create a 201 response with the location of the resource created as internet standard RFC 9110
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedAccount.getId()).toUri()).build();
    }

    @PutMapping()
    public ResponseEntity<Account> update(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.saveOrUpdate(account));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        if (accountService.deleteById(id) > 0) {
            // create a 204 response with empty body as internet standard RFC 9110
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/login")
    public ResponseEntity<AccountLoggedDto> logIn(@RequestBody AccountLogInDto accountLogInDto) {
        Optional<AccountLoggedDto> optionalAccountLoggedDto = accountService.logIn(accountLogInDto);
        return optionalAccountLoggedDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
