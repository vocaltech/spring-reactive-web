package fr.vocaltech.spring.reactiveweb.clients;

import fr.vocaltech.spring.reactiveweb.models.Employee;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class EmployeeClient {
    private final WebClient client;

    public EmployeeClient(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://localhost:8080").build();
    }

    public void consume() {
        Flux<Employee> fluxEmployee = client
                .get().uri("/employees")
                .retrieve()
                .bodyToFlux(Employee.class);

        fluxEmployee.subscribe(System.out::println);
    }
}
