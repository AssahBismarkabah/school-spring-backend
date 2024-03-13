package com.ssegning.com.school.config;

import com.ssegning.com.school.entity.StaffEntity;
import com.ssegning.com.school.entity.StaffRole;
import com.ssegning.com.school.repo.StaffRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.Set;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true
)
public class SecurityConfig {

    private static final String[] AUTH_PERMIT_LIST = {
            "/actuator/**",
            "/h2-console",
            "/h2-console/**",
    };

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public CommandLineRunner createStaff(StaffRepo staffRepo, PasswordEncoder passwordEncoder) {
        return args -> {
            var admin = new StaffEntity(
                    Set.of(StaffRole.CLEANING, StaffRole.TEACHER)
            );
            admin.setPassword(passwordEncoder.encode("password"));
            admin.setName("admin");

            staffRepo.saveAll(List.of(admin));
        };
    }

    @Bean
    public SecurityFilterChain securityWebFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        r -> r.requestMatchers(AUTH_PERMIT_LIST).permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(f -> {
                })
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .headers(h -> h.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
        ;

        return http.build();
    }


}
