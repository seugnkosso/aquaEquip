package com.example.aquaEquip.services;


import com.example.aquaEquip.data.entities.Panier;
import com.example.aquaEquip.web.dto.request.panier.PanierRequestDto;

public interface PanierService {
    Panier addPanier(PanierRequestDto panierRequestDto);

}
