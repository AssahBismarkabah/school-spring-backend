package com.ssegning.com.school.config;

import com.ssegning.com.school.model.BaseUserDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> {
            var authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication == null) return Optional.empty();

            var principal = authentication.getPrincipal();
            if (principal == null) return Optional.empty();

            if (principal instanceof BaseUserDetail user) {
                return Optional.of(user.getId().toString());
            }

            return Optional.of(principal.toString());
        };
    }
}
