package fr.vocaltech.spring.reactiveweb.repositories;

import fr.vocaltech.spring.reactiveweb.models.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

/*
public interface AccountCrudRepository extends ReactiveCrudRepository<Account, String> {
    Flux<Account> findAll();
}
*/

public interface AccountCrudRepository extends MongoRepository<Account, String> {
    @Override
    List<Account> findAll();
}
