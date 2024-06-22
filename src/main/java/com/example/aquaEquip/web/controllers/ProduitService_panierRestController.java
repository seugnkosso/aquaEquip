package com.example.aquaEquip.web.controllers;


import com.example.aquaEquip.web.dto.request.produitService.ProduitServiceRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api")
public interface ProduitService_panierRestController {
    @GetMapping("/produitServices_panier")
    ResponseEntity<?> produitServices_PanierIdPanier(
            @RequestParam Long idClient
    );

}
