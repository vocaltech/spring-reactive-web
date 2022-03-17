package fr.vocaltech.spring.reactiveweb;

import fr.vocaltech.spring.reactiveweb.models.Account;
import fr.vocaltech.spring.reactiveweb.repositories.AccountCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "fr.vocaltech.spring.reactiveweb.repositories")
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

            List<Account> accounts = accountCrudRepository.findAll();
            for (Account account: accounts) {
                System.out.println("account: " + account);
            }
        };
    }
}
