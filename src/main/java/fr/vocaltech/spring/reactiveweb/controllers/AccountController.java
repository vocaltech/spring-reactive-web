package fr.vocaltech.spring.reactiveweb.controllers;

import fr.vocaltech.spring.reactiveweb.models.Account;
import fr.vocaltech.spring.reactiveweb.repositories.AccountCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountCrudRepository accountCrudRepository;

    @GetMapping(
            path = "",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE
    )
    public Flux<Account> getAccounts() {
        return accountCrudRepository.findAll();
    }

    @GetMapping(
            path = "/{id}",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE
    )
    public Mono<Account> getAccountById(@PathVariable String id) {
        return accountCrudRepository.findById(id);
    }
}
