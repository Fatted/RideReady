package com.example.rrclientmodelresourceserver.config;

import com.example.rrclientmodelresourceserver.validation.CustomAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/veicoli/*").permitAll()
                        .requestMatchers("/clienti/").hasAuthority("SCOPE_clienti")
                        .requestMatchers("/amministratori-acquisto/").hasAuthority("SCOPE_amministratori-acquisto")
                        .requestMatchers("/amministratori-noleggio/").hasAuthority("SCOPE_amministratori-noleggio")
                        .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt()
                        .and()
                        .authenticationEntryPoint(customAuthenticationEntryPoint)
                );
        return http.build();
    }
}