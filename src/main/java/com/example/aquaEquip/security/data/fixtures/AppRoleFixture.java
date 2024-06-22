package com.example.aquaEquip.security.data.fixtures;

import com.example.aquaEquip.security.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
@Order(1)
@RequiredArgsConstructor
public class AppRoleFixture implements CommandLineRunner {
    private final SecurityService securityService;
    @Override
    public void run(String... args) throws Exception {
        securityService.saveRole("Admin");
        securityService.saveRole("Client");
    }
}
