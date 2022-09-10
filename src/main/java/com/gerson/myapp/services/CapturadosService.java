package com.gerson.myapp.services;

import com.gerson.myapp.exceptions.AppInternalServerErrorException;
import org.springframework.http.ResponseEntity;

public interface CapturadosService {

    public ResponseEntity<?> fetchApi() throws AppInternalServerErrorException;
}
