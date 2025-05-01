package com.footalentgroup.repositories.user;

import com.footalentgroup.TestConfig;
import com.footalentgroup.models.entities.UserEntity;
import com.footalentgroup.models.enums.Role;
import com.footalentgroup.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class UserRepositoryIT {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindById() {
        assertTrue(userRepository.findById(1L).isPresent());
        UserEntity user1 = userRepository.findById(1L).get();
        assertEquals("John Doe", user1.getName());
        assertEquals("john.doe@example.com", user1.getEmail());
        assertEquals(Role.FAN, user1.getRole());

        assertTrue(userRepository.findById(2L).isPresent());
        UserEntity user2 = userRepository.findById(2L).get();
        assertEquals("Jane Doe", user2.getName());
        assertEquals("jane.doe@example.com", user2.getEmail());
        assertEquals(Role.MUSICIAN, user2.getRole());
    }

    @Test
    void testFindByEmail() {
        assertTrue(userRepository.findByEmail("john.doe@example.com").isPresent());
    }
}
