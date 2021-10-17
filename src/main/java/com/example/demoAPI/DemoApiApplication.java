package com.example.demoAPI;

import com.example.demoAPI.students.Address;
import com.example.demoAPI.students.Gender;
import com.example.demoAPI.students.Student;
import com.example.demoAPI.students.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class DemoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApiApplication.class, args);
	}

    @Bean
    CommandLineRunner runner(StudentRepository repository) {
        return args -> {
            Address address = new Address("England", "London", "NE9");
            Student student = new Student(
                    "Jamila",
                    "Ahmed",
                    "Jamila@gmail.com",
                    Gender.FEMALE,
                    address,
                    List.of("Computer Science", "Math"),
                    BigDecimal.TEN,
                    LocalDateTime.now()
            );
            repository.insert(student);
        };
    }

}
