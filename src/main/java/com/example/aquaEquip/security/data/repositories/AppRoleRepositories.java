package com.example.aquaEquip.security.data.repositories;


import com.example.aquaEquip.security.data.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepositories extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String rolename);
}
