package com.footalentgroup.repositories.user;

import com.footalentgroup.models.entities.UserEntity;
import com.footalentgroup.models.enums.Role;
import com.footalentgroup.repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserSeederService {

    @Autowired
    private UserRepository userRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).info("----- User Initial Load -----");

        UserEntity[] users = {
                UserEntity.builder().name("John Doe").email("john.doe@example.com").password("12345678").role(Role.FAN).build(),
                UserEntity.builder().name("Jane Doe").email("jane.doe@example.com").password("1234abcd").role(Role.MUSICIAN).build(),
        };

        this.userRepository.saveAll(Arrays.asList(users));
    }

    public void deleteAll() {
        this.userRepository.deleteAll();
    }
}
