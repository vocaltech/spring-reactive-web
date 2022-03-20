package fr.vocaltech.spring.reactiveweb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Flux;

import fr.vocaltech.spring.reactiveweb.models.Account;
import fr.vocaltech.spring.reactiveweb.repositories.AccountCrudRepository;
import fr.vocaltech.spring.reactiveweb.models.User;
import fr.vocaltech.spring.reactiveweb.repositories.UserRepository;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class AccountSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountSpringApplication.class, args);
    }

    @Bean
    //public CommandLineRunner run(AccountCrudRepository accountCrudRepository)
    public CommandLineRunner run(UserRepository userRepository) {
        return args -> {
            //Mono<Account> saved = accountCrudRepository.save(new Account("1", "name1", 25000.0));
            //Mono<Account> saved = accountCrudRepository.save(new Account("2", "name2", 405000.0));
            //Mono<Account> saved = accountCrudRepository.save(new Account("3", "name3", 35030.0));

            //saved.subscribe();

            /*
            Flux<Account> accounts = accountCrudRepository.findAll();
            accounts.subscribe(account -> System.out.println(account));

             */
        };
    }
}
