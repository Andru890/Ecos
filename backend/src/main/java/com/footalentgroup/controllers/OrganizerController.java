package com.footalentgroup.controllers;

import com.footalentgroup.models.dtos.response.UserProfileResponseDto;
import com.footalentgroup.services.OrganizerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/organizer")
@RequiredArgsConstructor
public class OrganizerController {

    private final OrganizerService organizerService;

    @GetMapping("/profile")
    public ResponseEntity<UserProfileResponseDto> getProfile(@RequestHeader("Authorization") String authHeader) {
        return ResponseEntity.ok(organizerService.getMyOrganizerProfile(authHeader));
    }
}