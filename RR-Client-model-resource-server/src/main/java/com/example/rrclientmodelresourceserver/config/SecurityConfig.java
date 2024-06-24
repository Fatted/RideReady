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

    @Bean //configurazione del filtro di sicurezza
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/veicoli/amministratori/**").hasAnyAuthority("SCOPE_amministratori-acquisto","SCOPE_amministratori-noleggio") //autorizzo gli amministratori ad accedere alle risorse all'endpoint /veicoli/amministratori
                        .requestMatchers("/veicoli/amministratori-noleggio/**").hasAuthority("SCOPE_amministratori-noleggio") //autorizzo gli amministratori-noleggio ad accedere alle risorse all'endpoint /veicoli/amministratori-noleggio
                        .requestMatchers("/veicoli/amministratori-acquisto/**").hasAuthority("SCOPE_amministratori-acquisto") //autorizzo gli amministratori-acquisto ad accedere alle risorse all'endpoint /veicoli/amministratori-acquisto
                        .requestMatchers("/veicoli/clienti/**").hasAnyAuthority("SCOPE_clienti") //autorizzo i clienti ad accedere alle risorse all'endpoint /veicoli/clienti
                        .requestMatchers("/prenotazioni/clienti/**").hasAuthority("SCOPE_clienti") //autorizzo gli amministratori ad accedere alle risorse all'endpoint /prenotazioni/amministratori
                        .requestMatchers("/prenotazioni/amministratori-acquisto/**").hasAuthority("SCOPE_amministratori-acquisto") //autorizzo gli amministratori-acquisto ad accedere alle risorse all'endpoint /prenotazioni/amministratori/acquisto
                        .requestMatchers("/prenotazioni/amministratori-noleggio/**").hasAuthority("SCOPE_amministratori-noleggio") //autorizzo gli amministratori-noleggio ad accedere alle risorse all'endpoint /prenotazioni/amministratori/noleggio
                        .requestMatchers("/ordine/amministratori-acquisto/**").hasAuthority("SCOPE_amministratori-acquisto") //autorizzo gli amministratori-acquisto ad accedere alle risorse all'endpoint /ordine/amministratori/acquisto
                        .requestMatchers("/ordine/amministratori-noleggio/**").hasAuthority("SCOPE_amministratori-noleggio") //autorizzo gli amministratori-noleggio ad accedere alle risorse all'endpoint /ordine/amministratori/noleggio
                        .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt()
                        .and()
                        .authenticationEntryPoint(customAuthenticationEntryPoint) //setto l'entry point personalizzato per la gestione delle eccezioni di autenticazione
                )
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .accessDeniedHandler(customAccessDeniedHandler) //setto l'access denied handler personalizzato per la gestione delle eccezioni di accesso negato alla risorsa
                );
        return http.build();
    }
}