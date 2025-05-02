package com.footalentgroup.models.dtos.response;

import com.footalentgroup.models.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResponseDto {

    private String name;
    private String email;
    private Role role;
    private String ubicacion;
}