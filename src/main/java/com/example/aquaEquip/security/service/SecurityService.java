package com.example.aquaEquip.security.service;


import com.example.aquaEquip.data.entities.Client;
import com.example.aquaEquip.security.controllers.dtos.InscriptionClientRequestDto;
import com.example.aquaEquip.security.data.entities.AppRole;
import com.example.aquaEquip.security.data.entities.AppUser;

public interface SecurityService {
    AppUser getUserByUserName(String userName);

    AppUser saveUser(String username, String password);
    Client saveClient(InscriptionClientRequestDto inscriptionClientRequestDto);

    AppRole saveRole(String roleName);

    void addRoleToUser(String userName, String roleName);

    void removeRoleToUser(String userName, String roleName);
}
