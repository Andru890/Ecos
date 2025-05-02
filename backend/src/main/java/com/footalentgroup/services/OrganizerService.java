package com.footalentgroup.services;

import com.footalentgroup.models.dtos.response.UserProfileResponseDto;

public interface OrganizerService {
    UserProfileResponseDto getMyOrganizerProfile(String token);
}
