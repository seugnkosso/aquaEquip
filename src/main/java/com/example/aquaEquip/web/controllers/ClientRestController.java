package com.example.aquaEquip.web.controllers;


import com.example.aquaEquip.config.GlobalVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface ClientRestController {
    @GetMapping("/clients")
    ResponseEntity<?> clients(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = GlobalVariable.size) int size
    );

}
