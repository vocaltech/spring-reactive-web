package fr.vocaltech.spring.reactiveweb;

import fr.vocaltech.spring.reactiveweb.clients.GreetingClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GreetingSpringApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(GreetingSpringApplication.class);
        GreetingClient greetingClient = ctx.getBean(GreetingClient.class);

        // We need to block for the content here or the JVM might exit before the message is logged
        System.out.println(greetingClient.getMessage().block());
    }
}
