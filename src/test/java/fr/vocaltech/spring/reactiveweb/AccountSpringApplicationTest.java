package fr.vocaltech.spring.reactiveweb;

import fr.vocaltech.spring.reactiveweb.models.Account;
import fr.vocaltech.spring.reactiveweb.repositories.AccountCrudRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = fr.vocaltech.spring.reactiveweb.AccountSpringApplication.class)
public class AccountSpringApplicationTest {
    @Autowired
    AccountCrudRepository accountCrudRepository;

    @Test
    void testCount() {
        Mono<Long> count = accountCrudRepository.count();

        StepVerifier.create(count)
                .expectNext(new Long(3))
                .verifyComplete();
    }

    @Test
    void testFindAll() {
        Flux<Account> accounts = accountCrudRepository.findAll();

        StepVerifier.create(accounts)
                .expectNext(new Account("1", "name1", 25000.0))
                .expectNext(new Account("2", "name2", 405000.0))
                .assertNext(account -> {
                    assertEquals("3", account.getId());
                    assertEquals("name3", account.getOwner());
                    assertEquals(35030.0, account.getBalance());
                })
                .verifyComplete();
    }

    @Test
    void testFindById() {
        Mono<Account> accountById$ = accountCrudRepository.findById("2");

        StepVerifier.create(accountById$)
                .assertNext(account -> {
                    assertEquals("2", account.getId());
                    assertEquals("name2", account.getOwner());
                })
                .verifyComplete();
    }
}