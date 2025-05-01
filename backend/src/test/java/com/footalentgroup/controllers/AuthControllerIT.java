package com.footalentgroup.controllers;

import com.footalentgroup.models.dtos.request.LoginRequestDto;
import com.footalentgroup.models.dtos.request.UserRequestDto;
import com.footalentgroup.models.dtos.response.TokenResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
class AuthControllerIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testRegister() {
        UserRequestDto userDto = UserRequestDto.builder()
                .name("Fan User")
                .email("user@example.com")
                .password("abcd4567")
                .build();

        this.webTestClient
                .post()
                .uri(AuthController.AUTH)
                .body(BodyInserters.fromValue(userDto))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(TokenResponseDto.class)
                .value(System.out::println);
    }

    @Test
    void testRegisterConflict() {
        UserRequestDto userDto = UserRequestDto.builder()
                .name("Doe John")
                .email("john.doe@example.com")  // Email already exists
                .password("12345678")
                .build();

        this.webTestClient
                .post()
                .uri(AuthController.AUTH)
                .body(BodyInserters.fromValue(userDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }

    @Test
    void testRegisterNotValid() {
        UserRequestDto userDto = UserRequestDto.builder()
                .name("")   // Empty value
                .email("email@example.com")
                .password("12345678")
                .build();

        this.webTestClient
                .post()
                .uri(AuthController.AUTH)
                .body(BodyInserters.fromValue(userDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testLogin() {
        UserRequestDto userDto = UserRequestDto.builder().name("Login User").email("login.user@example.com").password("abcd4567").build();
        this.webTestClient
                .post()
                .uri(AuthController.AUTH)
                .body(BodyInserters.fromValue(userDto))
                .exchange()
                .expectStatus().isCreated();

        LoginRequestDto loginDto = LoginRequestDto.builder().email(userDto.getEmail()).password(userDto.getPassword()).build();
        this.webTestClient
                .post()
                .uri(AuthController.AUTH + AuthController.LOGIN)
                .body(BodyInserters.fromValue(loginDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(TokenResponseDto.class)
                .value(Assertions::assertNotNull);
    }

    @Test
    void testLoginBadCredentials() {
        LoginRequestDto loginDto = LoginRequestDto.builder().email("nn@example.com").password("00000000").build();

        this.webTestClient
                .post()
                .uri(AuthController.AUTH + AuthController.LOGIN)
                .body(BodyInserters.fromValue(loginDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.UNAUTHORIZED);
    }
}
