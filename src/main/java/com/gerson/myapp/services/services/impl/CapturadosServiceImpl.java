package com.gerson.myapp.services.services.impl;

import com.gerson.myapp.exceptions.AppInternalServerErrorException;
import com.gerson.myapp.services.CapturadosService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
public class CapturadosServiceImpl implements CapturadosService {

    @Value("${url.microservice.entrenador}")
    private String url_ms_entrenador;

    @Value("${url.microservice.pokemon}")
    private String url_ms_pokemon;

    private final RestTemplate restTemplate;

    public CapturadosServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<?> fetchApi() throws AppInternalServerErrorException {
        try {
            ResponseEntity<Boolean> response = restTemplate.exchange(url_ms_entrenador, HttpMethod.GET, getHeaders(), Boolean.class);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            log.error("[Error] fetchApi");
            log.error(e.getMessage());
            throw new AppInternalServerErrorException("Error al intentar conectar con ms-entenador");
        }
    }

    private HttpEntity<String> getHeaders() {
        String token = "fakeToken";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        return new HttpEntity<>(headers);
    }
}
