package com.footalentgroup.services.implementations;

import com.footalentgroup.models.dtos.response.UserProfileResponseDto;
import com.footalentgroup.models.entities.UserEntity;
import com.footalentgroup.repositories.UserRepository;
import com.footalentgroup.services.JwtService;
import com.footalentgroup.services.OrganizerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserProfileResponseDto getMyOrganizerProfile(String token) {
        String email = jwtService.email(token); // 1. Extrae el email del JWT

        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Organizador no encontrado")); // 2. Busca el user

        if (!user.getRole().name().equalsIgnoreCase("ORGANIZER")) {
            throw new RuntimeException("No sos organizador");
        }

        return UserProfileResponseDto.fromEntity(user); // 3. Devuelve el DTO limpio
    }
}