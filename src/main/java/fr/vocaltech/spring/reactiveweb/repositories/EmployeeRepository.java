package fr.vocaltech.spring.reactiveweb.repositories;

import fr.vocaltech.spring.reactiveweb.models.Employee;
import reactor.core.publisher.Flux;

public interface EmployeeRepository {
    Flux<Employee> findAllEmployees();
}
