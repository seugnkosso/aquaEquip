package com.example.aquaEquip.web.controllers.impl;

import com.example.aquaEquip.config.GlobalVariable;
import com.example.aquaEquip.data.entities.CategorieProduit;
import com.example.aquaEquip.services.CategorieProduitService;
import com.example.aquaEquip.web.controllers.CategorieProduitRestController;
import com.example.aquaEquip.web.dto.response.RestResponsDto;
import com.example.aquaEquip.web.dto.response.categorie.CategorieResponseDto;
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
public class CategorieProduitRestControllerImpl implements CategorieProduitRestController {
    private final CategorieProduitService categorieProduitService;
    @Override
    public ResponseEntity<?> categorieProduits() {
        List<CategorieProduit> categorieProduits = categorieProduitService.getAll();
        List<CategorieResponseDto> listCat = categorieProduits.stream().map(CategorieResponseDto::toDto).toList();
        Map<Object, Object> response = RestResponsDto.response(listCat, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
