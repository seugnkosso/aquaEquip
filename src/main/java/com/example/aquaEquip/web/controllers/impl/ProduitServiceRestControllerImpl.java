package com.example.aquaEquip.web.controllers.impl;

import com.example.aquaEquip.config.GlobalVariable;
import com.example.aquaEquip.data.entities.ProduitService;
import com.example.aquaEquip.services.ProduitAVendreService;
import com.example.aquaEquip.services.ProduitServiceService;
import com.example.aquaEquip.web.controllers.ProduitServiceRestController;
import com.example.aquaEquip.web.dto.request.produitService.ProduitServiceRequestDto;
import com.example.aquaEquip.web.dto.response.RestResponsDto;
import com.example.aquaEquip.web.dto.response.produitAVendre.ProduitAVendreResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@CrossOrigin(GlobalVariable.UrlFrontAngulaire)
public class ProduitServiceRestControllerImpl implements ProduitServiceRestController {
    private final ProduitServiceService produitServiceService;
    @Override
    public ResponseEntity<?> produitServices(
            @PathVariable Long idProduit
    ) {
        ProduitService produitServiceServiceById = produitServiceService.findById(idProduit);
        ProduitAVendreResponseDto produitAVendreResponseDto = ProduitAVendreResponseDto.prodServiceDto(produitServiceServiceById);
        Map<Object, Object> response = RestResponsDto.response(produitAVendreResponseDto, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> create(
            @RequestBody ProduitServiceRequestDto produitServiceRequestDto
    ) {
        ProduitService produitService = produitServiceService.creatProduitService(produitServiceRequestDto);
        Map<Object, Object> response = RestResponsDto.response(null, HttpStatus.CREATED);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> uploadFile(
            @RequestPart("file1") MultipartFile file1,
            @RequestPart("file2") MultipartFile file2,
            @RequestPart("file3") MultipartFile file3
    ) {
        try {
            file1.transferTo(new File("D:/Projet/JBA projet/AquaEquipFront/src/assets/imageUpLoad/" + file1.getOriginalFilename()));
        } catch (IOException e) {
            System.out.println("exist deja");
        }
        try {
            file2.transferTo(new File("D:/Projet/JBA projet/AquaEquipFront/src/assets/imageUpLoad/" + file2.getOriginalFilename()));
        } catch (IOException e) {
            System.out.println("exist deja");
        }
        try {
            file3.transferTo(new File("D:/Projet/JBA projet/AquaEquipFront/src/assets/imageUpLoad/" + file3.getOriginalFilename()));
        } catch (IOException e) {
            System.out.println("exist deja");
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
