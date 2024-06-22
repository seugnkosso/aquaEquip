package com.example.aquaEquip.web.controllers.impl;

import com.example.aquaEquip.config.GlobalVariable;
import com.example.aquaEquip.data.entities.Service;
import com.example.aquaEquip.services.ServiceService;
import com.example.aquaEquip.web.controllers.ServiceRestController;
import com.example.aquaEquip.web.dto.response.RestResponsDto;
import com.example.aquaEquip.web.dto.response.produitAVendre.ProduitAVendreResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(GlobalVariable.UrlFrontAngulaire)
public class ServiceRestControllerImpl implements ServiceRestController {
    private final ServiceService serviceService;
    @Override
    public ResponseEntity<?> services(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = GlobalVariable.size) int size,
            @RequestParam String libelle,
            @RequestParam String idCategori
    ) {
        Page<Service> allByLibelle = serviceService.getAllByLibelleAndCategori(libelle, Long.valueOf(idCategori), PageRequest.of(page, size));
        Page<ProduitAVendreResponseDto> produitAVendreResponseDtos = allByLibelle.map(ProduitAVendreResponseDto::ServicetoDto);
        Map<Object, Object> response = RestResponsDto.response(
                produitAVendreResponseDtos.getContent(),
                produitAVendreResponseDtos.getTotalElements(),
                produitAVendreResponseDtos.getTotalPages(),
                (long) produitAVendreResponseDtos.getContent().size(),
                new int[produitAVendreResponseDtos.getTotalPages()],
                produitAVendreResponseDtos.getTotalPages(),
                produitAVendreResponseDtos.getNumber(),
                HttpStatus.OK
        );
        return new ResponseEntity<>(response,HttpStatus.OK);

    }
}
