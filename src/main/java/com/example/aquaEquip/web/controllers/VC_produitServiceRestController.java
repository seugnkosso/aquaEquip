package com.example.aquaEquip.web.controllers;


import com.example.aquaEquip.config.GlobalVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api")
public interface VC_produitServiceRestController {
    @GetMapping("/VC_produitServices/Commande")
    ResponseEntity<?> VC_produitServicesCommande(
            @RequestParam Long idCommande
    );
}
