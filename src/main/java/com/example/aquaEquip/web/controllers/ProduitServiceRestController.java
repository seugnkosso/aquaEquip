package com.example.aquaEquip.web.controllers;


import com.example.aquaEquip.config.GlobalVariable;
import com.example.aquaEquip.web.dto.request.produitService.ProduitServiceRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api")
public interface ProduitServiceRestController {
    @GetMapping("/produitServices/{idProduit}")
    ResponseEntity<?> produitServices(
            @PathVariable Long idProduit
    );
    @PostMapping("/produitServices")
    ResponseEntity<?> create(
            @RequestBody ProduitServiceRequestDto produitServiceRequestDto
            );

    @PostMapping("/produitServices/upload")
    public ResponseEntity<String> uploadFile(
            @RequestPart("file1") MultipartFile file1,
            @RequestPart("file2") MultipartFile file2,
            @RequestPart("file3") MultipartFile file3
    );
}
