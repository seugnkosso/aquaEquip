package com.example.aquaEquip.web.controllers.impl;

import com.example.aquaEquip.config.GlobalVariable;
import com.example.aquaEquip.data.entities.VC_produitService;
import com.example.aquaEquip.services.VC_produitServiceService;
import com.example.aquaEquip.web.controllers.VC_produitServiceRestController;
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
public class VC_produitServiceRestControllerImpl implements VC_produitServiceRestController {
    private final VC_produitServiceService vcProduitServiceService;
    @Override
    public ResponseEntity<?> VC_produitServicesCommande(Long idCommande) {
        List<VC_produitService> allVCProduitService = vcProduitServiceService.getAllVC_produitService(idCommande);
        List<ProduitService_panierResponseDto> vcProduitService = allVCProduitService.stream().map(ProduitService_panierResponseDto::toDtoVC).toList();
        Map<Object, Object> response = RestResponsDto.response(vcProduitService, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
