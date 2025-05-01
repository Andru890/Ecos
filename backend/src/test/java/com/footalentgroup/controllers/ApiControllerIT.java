package com.footalentgroup.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Map;

@RestTestConfig
public class ApiControllerIT {

    @Autowired
    private WebTestClient webClient;

    @Test
    void testRead() {
        this.webClient
                .get()
                .uri(ApiController.API)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Map.class)
                .isEqualTo(Map.of(
                        "name", "Ecos",
                        "version", "1.0.0",
                        "description", "Foo Talent Group. Equipo 22 Noche"
                ));
    }
}
