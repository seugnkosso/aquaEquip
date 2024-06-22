package com.example.aquaEquip.web.controllers.impl;

import com.example.aquaEquip.config.GlobalVariable;
import com.example.aquaEquip.data.entities.Address;
import com.example.aquaEquip.services.AddressService;
import com.example.aquaEquip.web.controllers.AddressRestController;
import com.example.aquaEquip.web.dto.response.RestResponsDto;
import com.example.aquaEquip.web.dto.response.address.AddressResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(GlobalVariable.UrlFrontAngulaire)
public class AddressRestControllerImpl implements AddressRestController {
    private final AddressService addressService;
    @Override
    public ResponseEntity<?> address(Long idClient) {
        Address addressByidClienf = addressService.getAddressByidClienf(idClient);
        AddressResponseDto addressResponseDto = AddressResponseDto.toDto(addressByidClienf);
        Map<Object, Object> response = RestResponsDto.response(addressResponseDto, HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
