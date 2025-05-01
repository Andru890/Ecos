package com.footalentgroup.services;

import com.footalentgroup.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class JwtServiceIT {

    @Autowired
    private JwtService jwtService;

    @Test
    void testExtractToken() {
        assertEquals("t.t.t", jwtService.extractToken("Bearer t.t.t"));
    }

    @Test
    void testCreateAndVerifyToken() {
        String token = jwtService.createToken("email@example.com", "name", "ROLE");

        assertEquals(3, token.split("\\.").length);
        assertEquals("email@example.com", jwtService.email(token));
        assertEquals("name", jwtService.name(token));
        assertEquals("ROLE", jwtService.role(token));
    }
}
