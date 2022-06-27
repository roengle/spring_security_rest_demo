package com.robert.springsecurityrestdemo.util;

import com.robert.springsecurityrestdemo.entity.Employee;
import com.robert.springsecurityrestdemo.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoader {

    private static final Logger log = LoggerFactory.getLogger(DatabaseLoader.class);

    @Bean
    CommandLineRunner run(EmployeeRepository repository){
        return args -> {
            log.info("Loading {}", repository.save(
                    new Employee("Robert", "Engle", "SWE Intern")
            ));
            log.info("Loading {}", repository.save(
                    new Employee("Bob", "Bob", "Bob")
            ));
            log.info("Loading {}", repository.save(
                    new Employee("Alice", "Alice", "Alice")
            ));
        };
    }
}
