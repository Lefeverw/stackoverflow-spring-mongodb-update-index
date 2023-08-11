package com.wouterlefever.stackoverflow;

import com.wouterlefever.stackoverflow.entity.Person;
import com.wouterlefever.stackoverflow.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final PersonRepository personRepository;

    public Application(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        Person person = new Person("John", "Doe", "1");
        personRepository.save(person);
    }
}