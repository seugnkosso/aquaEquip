package com.example.aquaEquip.web.controllers;


import com.example.aquaEquip.web.dto.request.panier.PanierRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public interface PanierRestController {
    @PostMapping("/paniers/add")
    ResponseEntity<?> addPaniers(@RequestBody PanierRequestDto panierRequestDto);

}
