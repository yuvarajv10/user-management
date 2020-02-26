package com.user.service.demo.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Jpa Repository configuration.
 * 
 * @author yuvaraj
 *
 */
@Configuration
@EnableJpaRepositories("com.user.service.demo.repository")
@EnableAutoConfiguration
@EntityScan("com.user.service.demo.entity")
public class RepositoryConfig {

}
