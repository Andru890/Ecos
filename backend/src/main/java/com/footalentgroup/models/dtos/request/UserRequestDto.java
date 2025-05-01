package com.footalentgroup.models.dtos.request;

import com.footalentgroup.models.entities.UserEntity;
import com.footalentgroup.models.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
public class UserRequestDto {

    @NotBlank(message = "El nombre no puede estar vacío.")
    private final String name;

    @NotBlank(message = "El correo electrónico no puede estar vacío.")
    @Email(message = "El correo electrónico no tiene un formato válido.")
    private final String email;

    @NotBlank(message = "La contraseña no puede estar vacía.")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres.")
    private final String password;

    private Role role;

    public void doDefault() {
        if (Objects.isNull(role)) {
            this.role = Role.FAN;
        }
    }

    public UserEntity toEntity() {
        this.doDefault();

        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(this, user);
        user.setPassword(new BCryptPasswordEncoder().encode(this.password));
        return user;
    }
}
