package com.example.aquaEquip.security.controllers.impl;


import com.example.aquaEquip.data.entities.Client;
import com.example.aquaEquip.security.controllers.SecurityController;
import com.example.aquaEquip.security.controllers.dtos.AuthenticationRequestDto;
import com.example.aquaEquip.security.controllers.dtos.InscriptionClientRequestDto;
import com.example.aquaEquip.security.controllers.dtos.TokenReponseDto;
import com.example.aquaEquip.security.service.SecurityService;
import com.example.aquaEquip.security.service.impl.JwtService;
import com.example.aquaEquip.web.dto.response.RestResponsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
@Slf4j
public class SecurityControllerImpl implements SecurityController {
    private final SecurityService securityService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    @Override
    public ResponseEntity<Map<Object, Object>> login(@RequestBody AuthenticationRequestDto authenticationRequestDto) {
        log.info(authenticationRequestDto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequestDto.getUsername(), authenticationRequestDto.getPassword()));
        Map<Object, Object> response;
        if(authenticate.isAuthenticated()){
            //Generer le token
             String token= jwtService.createToken(authenticationRequestDto.getUsername(),new HashMap<String,Object>());
            TokenReponseDto tokenDto = TokenReponseDto.builder()
                    .id(securityService.getUserByUserName(authenticationRequestDto.getUsername()).getId())
                    .token(token)
                    .username(authenticationRequestDto.getUsername())
                    .roles(authenticate.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                    .build();
            response= RestResponsDto.response(tokenDto, HttpStatus.OK);
        }else{
            response= RestResponsDto.response(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(response);


    }

    @Override
    public ResponseEntity<Map<Object, Object>> clientInscrit(InscriptionClientRequestDto inscriptionClientRequestDto) {
        Client client = securityService.saveClient(inscriptionClientRequestDto);
        Map<Object, Object> response = RestResponsDto.response(client, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
