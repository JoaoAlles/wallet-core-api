package com.wallet.core.config;

import com.wallet.core.domain.entity.Category;
import com.wallet.core.domain.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(CategoryRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Category(null, "Food", "Eating and drinking"));
                repository.save(new Category(null, "Transport", "Bus, Uber, Fuel"));
                repository.save(new Category(null, "Salary", "Monthly income"));
            }
        };
    }
}
