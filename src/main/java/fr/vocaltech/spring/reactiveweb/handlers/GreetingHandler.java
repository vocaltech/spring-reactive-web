package fr.vocaltech.spring.reactiveweb.handlers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import fr.vocaltech.spring.reactiveweb.models.Greeting;

@Component
public class GreetingHandler {
    public Mono<ServerResponse> hello(ServerRequest req) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Greeting("Hello Spring Reactive from GreetingHandler !")));
    }

}
