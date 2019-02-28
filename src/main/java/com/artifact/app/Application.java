package com.artifact.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.artifact")
@EnableJpaRepositories(basePackages = "com.artifact.app.domain.repository")
@SpringBootApplication
@Slf4j
public class Application extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public CommandLineRunner getRunner(UserRepo userRepo) {
//        return args -> {
//            log.info("Repo: " + userRepo);
//            User user = new User(1L, "admin", "ksjflksj", true, Role.ADMIN);
//            userRepo.save(user);
//        };
//    }
}