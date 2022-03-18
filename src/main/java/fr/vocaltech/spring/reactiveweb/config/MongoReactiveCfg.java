package fr.vocaltech.spring.reactiveweb.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;

@Configuration
public class MongoReactiveCfg extends AbstractReactiveMongoConfiguration {
    private final MongoProperties properties;

    public MongoReactiveCfg(MongoProperties properties) {
        this.properties = properties;
    }

    @Bean
    public MongoClient reactiveMongoClient() {
        MongoCredential credential = MongoCredential.createCredential(
                properties.getUsername(),
                properties.getAuthenticationDatabase(),
                properties.getPassword());

        MongoClientSettings settings = MongoClientSettings.builder()
                .credential(credential)
                .build();

        return MongoClients.create(settings);
    }

    @Override
    protected String getDatabaseName() {
        return "reactive_spring";
    }
}
