package com.example.aquaEquip.web.controllers.impl;

import com.example.aquaEquip.config.GlobalVariable;
import com.example.aquaEquip.data.entities.Panier;
import com.example.aquaEquip.services.PanierService;
import com.example.aquaEquip.web.controllers.PanierRestController;
import com.example.aquaEquip.web.dto.request.panier.PanierRequestDto;
import com.example.aquaEquip.web.dto.response.RestResponsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(GlobalVariable.UrlFrontAngulaire)
public class PanierRestControllerImpl implements PanierRestController {
    private final PanierService panierService;
    @Override
    public ResponseEntity<?> addPaniers(@RequestBody PanierRequestDto panierRequestDto) {
        Panier panier = panierService.addPanier(panierRequestDto);
        Map<Object, Object> response = RestResponsDto.response(panier, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
