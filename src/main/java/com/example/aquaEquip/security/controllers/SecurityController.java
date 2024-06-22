package com.example.aquaEquip.security.controllers;

import com.example.aquaEquip.security.controllers.dtos.AuthenticationRequestDto;
import com.example.aquaEquip.security.controllers.dtos.InscriptionClientRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface SecurityController {
    @PostMapping("/login")
    ResponseEntity<Map<Object, Object>> login(@RequestBody AuthenticationRequestDto authenticationRequestDto);

    @PostMapping("/login/client/inscrit")
    ResponseEntity<Map<Object, Object>> clientInscrit(@RequestBody InscriptionClientRequestDto inscriptionClientRequestDto);

}
