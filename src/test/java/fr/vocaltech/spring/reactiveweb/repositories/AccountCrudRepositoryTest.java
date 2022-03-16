package fr.vocaltech.spring.reactiveweb.repositories;

import fr.vocaltech.spring.reactiveweb.models.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = fr.vocaltech.spring.reactiveweb.AccountSpringApplication.class)
public class AccountCrudRepositoryTest {
    @Autowired
    private AccountCrudRepository accountCrudRepository;

    @Test
    public void testSaveAccount() {
        Account saved = accountCrudRepository.save(new Account("1", "name1", 25000.0)).block();
        System.out.println("saved account: " + saved);
    }
}