package com.example.aquaEquip.web.controllers.impl;

import com.example.aquaEquip.config.GlobalVariable;
import com.example.aquaEquip.data.entities.ProduitService_panier;
import com.example.aquaEquip.services.ProduitServicePanierService;
import com.example.aquaEquip.web.controllers.ProduitService_panierRestController;
import com.example.aquaEquip.web.dto.response.RestResponsDto;
import com.example.aquaEquip.web.dto.response.produitServicePanier.ProduitService_panierResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(GlobalVariable.UrlFrontAngulaire)
public class ProduitService_panierRestControllerImpl implements ProduitService_panierRestController {
    private final ProduitServicePanierService produitServicePanierService;
    @Override
    public ResponseEntity<?> produitServices_PanierIdPanier(Long idClient) {
        List<ProduitService_panier> allProduitServicePanierByClient = produitServicePanierService.getAllProduitServicePanierByClient(idClient);
        List<ProduitService_panierResponseDto> produitServicePanierResponseDtos = allProduitServicePanierByClient.stream().map(ProduitService_panierResponseDto::toDto).toList();
        Map<Object, Object> response = RestResponsDto.response(produitServicePanierResponseDtos, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
