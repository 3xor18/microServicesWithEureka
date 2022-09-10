//Esta Es la clase de entrada para los request de capturados
package com.gerson.myapp.controllers;

import com.gerson.myapp.exceptions.AppInternalServerErrorException;
import com.gerson.myapp.services.CapturadosService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@CrossOrigin("*")
@RequestMapping("capturados")
public class CapturadosController {

    private final CapturadosService capturadosService;

    public CapturadosController(CapturadosService capturadosService) {
        this.capturadosService = capturadosService;
    }

    @GetMapping("")
    public ResponseEntity<?> saludar(){
        return ResponseEntity.status(HttpStatus.OK).body("Hola");
    }

    @GetMapping("/api")
    public ResponseEntity<?> fecth() throws AppInternalServerErrorException {
        return capturadosService.fetchApi();
    }

}
