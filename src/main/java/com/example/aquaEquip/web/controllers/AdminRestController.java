package com.example.aquaEquip.web.controllers;


import com.example.aquaEquip.config.GlobalVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api")
public interface AdminRestController {
    @GetMapping("/admins")
    ResponseEntity<?> admins(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = GlobalVariable.size) int size
    );

}
