package com.footalentgroup.controllers;

import com.footalentgroup.models.dtos.request.LoginRequestDto;
import com.footalentgroup.models.dtos.request.UserRequestDto;
import com.footalentgroup.models.dtos.response.TokenResponseDto;
import com.footalentgroup.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AuthController.AUTH)
@RequiredArgsConstructor
public class AuthController {
    public static final String AUTH = "/auth";
    public static final String LOGIN = "/login";

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<TokenResponseDto> register(@Valid @RequestBody UserRequestDto userDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.authService.createUser(userDto.toEntity()));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<TokenResponseDto> login(@Valid @RequestBody LoginRequestDto loginDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.authService.login(loginDto));
    }
}
