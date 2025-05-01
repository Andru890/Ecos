package com.footalentgroup.services;

import com.footalentgroup.models.dtos.request.LoginRequestDto;
import com.footalentgroup.models.dtos.response.TokenResponseDto;
import com.footalentgroup.models.entities.UserEntity;

public interface AuthService {
    public TokenResponseDto createUser(UserEntity userDto);

    public TokenResponseDto login(LoginRequestDto loginRequestDto);
}