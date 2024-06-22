package com.example.aquaEquip.security.service.impl;


import com.example.aquaEquip.data.entities.Client;
import com.example.aquaEquip.data.entities.Panier;
import com.example.aquaEquip.data.repositories.ClientRepository;
import com.example.aquaEquip.data.repositories.PanierRepository;
import com.example.aquaEquip.security.controllers.dtos.InscriptionClientRequestDto;
import com.example.aquaEquip.security.data.entities.AppRole;
import com.example.aquaEquip.security.data.entities.AppUser;
import com.example.aquaEquip.security.data.repositories.AppRoleRepositories;
import com.example.aquaEquip.security.data.repositories.AppUserRepositories;
import com.example.aquaEquip.security.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SecurityServiceImpl implements SecurityService, UserDetailsService {
    private final AppRoleRepositories appRoleRepositories;
    private final AppUserRepositories appUserRepositories;
    private final ClientRepository clientRepository;
    private final PanierRepository panierRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AppRole saveRole(String roleName) {
        AppRole role = appRoleRepositories.findByRoleName(roleName);
        if (role != null) {
            throw new RuntimeException("role existe deja");
        }
        role = new AppRole(roleName, null);
        return appRoleRepositories.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        AppRole role = appRoleRepositories.findByRoleName(roleName);
        if (role == null) {
            throw new RuntimeException("role not found");
        }
        AppUser user = appUserRepositories.findByUsername(userName);
        if (user == null) {
            throw new RuntimeException("user not found");
        }
        user.getRoles().add(role);
        appUserRepositories.save(user);
    }

    @Override
    public void removeRoleToUser(String userName, String roleName) {
        AppRole role = appRoleRepositories.findByRoleName(roleName);
        if (role == null) {
            throw new RuntimeException("role not found");
        }
        AppUser user = appUserRepositories.findByUsername(userName);
        if (user == null) {
            throw new RuntimeException("user not found");
        }
        user.getRoles().remove(role);
        appUserRepositories.save(user);
    }

    @Override
    public AppUser getUserByUserName(String userName) {
        return appUserRepositories.findByUsername(userName);
    }

    @Override
    public AppUser saveUser(String username, String password) {
        AppUser user = appUserRepositories.findByUsername(username);
        if (user != null) {
            throw new RuntimeException("l'utilisateur existe deja");
        }
        user = new AppUser("user", "user", "user", username, passwordEncoder.encode(password), null);
        return appUserRepositories.save(user);
    }

    @Override
    public Client saveClient(InscriptionClientRequestDto inscriptionClientRequestDto) {
        AppUser user = appUserRepositories.findByUsername(inscriptionClientRequestDto.getUsername());
        if (user != null) {
            throw new RuntimeException("l'utilisateur existe deja");
        }
        Client client = new Client();
        client.setNomComplet(inscriptionClientRequestDto.getNomComplet());
        client.setEmail(inscriptionClientRequestDto.getEmail());
        client.setTelephone(inscriptionClientRequestDto.getTelephone());
        client.setUsername(inscriptionClientRequestDto.getUsername());
        client.setPassword(passwordEncoder.encode(inscriptionClientRequestDto.getPassword()));
        Panier panier = new Panier();
        panierRepository.save(panier);
        client.setPanier(panier);
        client.getRoles().add(appRoleRepositories.findByRoleName("Client"));
        return clientRepository.save(client);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepositories.findByUsername(username);
        List<SimpleGrantedAuthority> authorize = appUser.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).toList();
        return new User(appUser.getUsername(), appUser.getPassword(), authorize);
    }
}
