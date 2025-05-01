package com.footalentgroup.services.impl;

import com.footalentgroup.exceptions.ConflictException;
import com.footalentgroup.models.dtos.request.LoginRequestDto;
import com.footalentgroup.models.dtos.response.TokenResponseDto;
import com.footalentgroup.models.entities.UserEntity;
import com.footalentgroup.repositories.UserRepository;
import com.footalentgroup.services.AuthService;
import com.footalentgroup.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public TokenResponseDto createUser(UserEntity user) {
        this.assertEmailNotExist(user.getEmail());

        UserEntity savedUser = this.userRepository.save(user);
        String token = this.jwtService.createToken(savedUser.getEmail(), savedUser.getName(), savedUser.getRole().name());
        return new TokenResponseDto(token);
    }

    @Override
    public TokenResponseDto login(LoginRequestDto loginDto) {
        UserEntity user = userRepository.findByEmail(loginDto.getEmail()).orElse(null);

        if (user == null || !passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("");
        }


        return new TokenResponseDto(jwtService.createToken(user.getEmail(), user.getName(), user.getRole().name()));
    }

    private void assertEmailNotExist(String email) {
        this.userRepository
                .findByEmail(email)
                .ifPresent(user -> { throw new ConflictException("El correo ya está registrado: " + email); });
    }
}
