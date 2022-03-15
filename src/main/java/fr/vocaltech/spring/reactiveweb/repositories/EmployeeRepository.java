package fr.vocaltech.spring.reactiveweb.repositories;

import fr.vocaltech.spring.reactiveweb.models.Employee;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeRepository {
    static Map<String, Employee> employees;

    static {
        employees = new HashMap<>();
        employees.put("1", new Employee(1, "employee_1"));
        employees.put("2", new Employee(2, "employee_2"));
        employees.put("3", new Employee(3, "employee_3"));
        employees.put("4", new Employee(4, "employee_4"));
    }

    public Flux<Employee> findAllEmployees() {
        return Flux.fromIterable(employees.values());
    }

}
