package fr.vocaltech.spring.reactiveweb;

import fr.vocaltech.spring.reactiveweb.clients.EmployeeClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EmployeeSpringApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(EmployeeSpringApplication.class, args);

		EmployeeClient client = ctx.getBean(EmployeeClient.class);
		client.consume();
	}

}
