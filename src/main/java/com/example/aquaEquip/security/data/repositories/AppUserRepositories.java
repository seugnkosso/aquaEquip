package com.example.aquaEquip.security.data.repositories;

import com.example.aquaEquip.security.data.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepositories extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
