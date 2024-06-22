package com.example.aquaEquip.web.controllers.impl;

import com.example.aquaEquip.config.GlobalVariable;
import com.example.aquaEquip.data.entities.Commande;
import com.example.aquaEquip.services.CommandeService;
import com.example.aquaEquip.web.controllers.CommandeRestController;
import com.example.aquaEquip.web.dto.response.RestResponsDto;
import com.example.aquaEquip.web.dto.response.commande.CommandeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(GlobalVariable.UrlFrontAngulaire)
public class CommandeRestControllerImpl implements CommandeRestController {
    private final CommandeService commandeService;
    @Override
    public ResponseEntity<?> AllcommandesClientID(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size,
            @RequestParam Long idClient
    ) {
        Page<Commande> allCommandeByClientId = commandeService.getAllCommandeByClientId(idClient, PageRequest.of(page, size));
        Page<CommandeResponseDto> commandeResponseDtos = allCommandeByClientId.map(CommandeResponseDto::toDto);
        Map<Object, Object> response = RestResponsDto.response(
                commandeResponseDtos.getContent(),
                commandeResponseDtos.getTotalElements(),
                commandeResponseDtos.getTotalPages(),
                (long) commandeResponseDtos.getContent().size(),
                new int[commandeResponseDtos.getTotalPages()],
                commandeResponseDtos.getTotalPages(),
                commandeResponseDtos.getNumber(),
                HttpStatus.OK

        );
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> commandesClientID(Long idClient) {
        Commande commande = commandeService.addCommande(idClient);
        Map<Object, Object> response = RestResponsDto.response(commande, HttpStatus.CREATED);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
