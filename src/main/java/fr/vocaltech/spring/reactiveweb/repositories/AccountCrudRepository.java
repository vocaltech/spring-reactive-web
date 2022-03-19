package fr.vocaltech.spring.reactiveweb.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import fr.vocaltech.spring.reactiveweb.models.Account;
import reactor.core.publisher.Mono;

public interface AccountCrudRepository extends ReactiveCrudRepository<Account, String> {
    Flux<Account> findAll();
    Mono<Long> count();
}
