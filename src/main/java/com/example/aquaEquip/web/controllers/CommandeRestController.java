package com.example.aquaEquip.web.controllers;


import com.example.aquaEquip.config.GlobalVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface CommandeRestController {
    @GetMapping("/commandes/all/client")
    ResponseEntity<?> AllcommandesClientID(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = GlobalVariable.size) int size,
        @RequestParam Long idClient
    );
    @GetMapping("/commandes/client")
    ResponseEntity<?> commandesClientID(
        @RequestParam Long idClient
    );

}
