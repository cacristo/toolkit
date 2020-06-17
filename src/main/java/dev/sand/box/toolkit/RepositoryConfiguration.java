package dev.sand.box.toolkit;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "dev.sand.box.toolkit.repository")
public class RepositoryConfiguration {
}
