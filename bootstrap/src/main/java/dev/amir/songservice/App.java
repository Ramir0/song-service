package dev.amir.songservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({
        "dev.amir.songservice.framework",
        "dev.amir.songservice.application",
        "dev.amir.songservice.domain"
})
@EnableJpaRepositories("dev.amir.songservice.framework.output.sql")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
