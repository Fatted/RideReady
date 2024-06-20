package com.example.rrclientmodelresourceserver.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationEntryPoint.class);

    @Override
    public void commence(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, AuthenticationException authException) throws IOException, jakarta.servlet.ServletException {
        logger.info("CustomAuthenticationEntryPoint"); //logger
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); //setto lo status della response a 401
        response.setContentType("application/json"); //setto il content type della response a json

        Map<String, String> error = new HashMap<>(); //creo una mappa per l'errore
        error.put("error", "Unauthorized"); //setto il tipo di errore
        error.put("message", "Il Token inserito di Autenticazione non è valido o è scaduto."); //setto il messaggio di errore

        ObjectMapper objectMapper = new ObjectMapper(); //creo un oggetto ObjectMapper
        response.getWriter().write(objectMapper.writeValueAsString(error)); //scrivo la mappa come json
    }
}
