package com.example.rrclientmodelresourceserver.config;

import com.example.rrclientmodelresourceserver.validation.CustomAccessDeniedHandler;
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

    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/veicoli/amministratori/**").hasAnyAuthority("SCOPE_amministratori-acquisto","SCOPE_amministratori-noleggio")
                        .requestMatchers("/veicoli/amministratori-noleggio/**").hasAuthority("SCOPE_amministratori-noleggio")
                        .requestMatchers("/veicoli/amministratori-acquisto/**").hasAuthority("SCOPE_amministratori-acquisto")
                        .requestMatchers("/veicoli/clienti/**").hasAnyAuthority("SCOPE_clienti")
                        .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt()
                        .and()
                        .authenticationEntryPoint(customAuthenticationEntryPoint)
                )
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .accessDeniedHandler(customAccessDeniedHandler)
                );
        return http.build();
    }
}