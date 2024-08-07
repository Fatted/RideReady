package com.example.rrclientmodelresourceserver.validation;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    private static final Logger logger = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);

    @Override
    public void handle(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        logger.info("CustomAccessDeniedHandler"); //logger
        response.setStatus(HttpServletResponse.SC_FORBIDDEN); //setto lo status della response a 403
        response.setContentType("application/json"); //setto il content type della response a json
        Map<String, String> error = new HashMap<>(); //creo una mappa per l'errore
        error.put("error", "Forbidden"); //setto il tipo di errore
        error.put("message", "Accesso negato alla risorsa"); //setto il messaggio di errore
        response.getWriter().write(new ObjectMapper().writeValueAsString(error)); //scrivo la mappa come json
    }
}

