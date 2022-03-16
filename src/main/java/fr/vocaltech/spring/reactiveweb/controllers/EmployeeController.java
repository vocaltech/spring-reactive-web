package fr.vocaltech.spring.reactiveweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import fr.vocaltech.spring.reactiveweb.models.Employee;
import fr.vocaltech.spring.reactiveweb.repositories.EmployeeRepositoryMap;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepositoryMap employeeRepository;

    @GetMapping
    private Flux<Employee> getAllEmployees() {
        return employeeRepository.findAllEmployees();
    }
}
