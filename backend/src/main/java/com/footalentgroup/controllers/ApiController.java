package com.footalentgroup.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(ApiController.API)
public class ApiController {
    public static final String API = "/docs";

    @GetMapping
    public ResponseEntity<?> read() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of(
                        "name", "Ecos",
                        "version", "1.0.0",
                        "description", "Foo Talent Group. Equipo 22 Noche"
                ));
    }
}
