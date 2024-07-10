package com.example.rrclientmodeloauth2server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests.anyRequest().authenticated()
                )
                .formLogin(withDefaults());
        return http.build();
    }

    @Bean
    UserDetailsService users() {
        UserDetails clienti = User.withUsername("clienti")
                .password("{noop}clienti-password")
                .roles("clienti")
                .build();
        UserDetails amministratoriAcquisto =User.withUsername("amministratori-acquisto")
                .password("{noop}amm-acquisto-password")
                .roles("amministratori-acquisto")
                .build();
        UserDetails amministratoriNoleggio =User.withUsername("amministratori-noleggio")
                .password("{noop}amm-noleggio-password")
                .roles("amministratori-noleggio")
                .build();
        return new InMemoryUserDetailsManager(clienti,amministratoriAcquisto,amministratoriNoleggio);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
