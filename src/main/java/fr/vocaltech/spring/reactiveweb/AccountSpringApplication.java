package fr.vocaltech.spring.reactiveweb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Flux;

import fr.vocaltech.spring.reactiveweb.models.Account;
import fr.vocaltech.spring.reactiveweb.repositories.AccountCrudRepository;

@SpringBootApplication
public class AccountSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountSpringApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(AccountCrudRepository accountCrudRepository) {
        return args -> {
            //Account saved = accountCrudRepository.save(new Account("1", "name1", 25000.0));
            //Account saved = accountCrudRepository.save(new Account("2", "name2", 405000.0));
            //Account saved = accountCrudRepository.save(new Account("3", "name3", 35030.0));

            /*
            List<Account> accounts = accountCrudRepository.findAll();
            for (Account account: accounts) {
                System.out.println("account: " + account);
            }
            */

            Flux<Account> accounts = accountCrudRepository.findAll();
            accounts.subscribe(account -> System.out.println(account));
        };
    }
}
