package com.example.aquaEquip.services.impl;

import com.example.aquaEquip.data.entities.Client;
import com.example.aquaEquip.data.entities.Panier;
import com.example.aquaEquip.data.entities.ProduitService;
import com.example.aquaEquip.data.entities.ProduitService_panier;
import com.example.aquaEquip.data.repositories.ClientRepository;
import com.example.aquaEquip.data.repositories.PanierRepository;
import com.example.aquaEquip.data.repositories.ProduitServiceRepository;
import com.example.aquaEquip.data.repositories.ProduitService_panierRepository;
import com.example.aquaEquip.services.PanierService;
import com.example.aquaEquip.web.dto.request.panier.PanierRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PanierServiceImpl implements PanierService {
    private final ProduitService_panierRepository produitServicePanierRepository;
    private final ClientRepository clientRepository;
    private final ProduitServiceRepository produitServiceRepository;
    @Override
    public Panier addPanier(PanierRequestDto panierRequestDto) {
        ProduitService produitService = produitServiceRepository.findById(panierRequestDto.getIdProduit()).get();
        Client client = clientRepository.findById(panierRequestDto.getIdClient()).get();

        ProduitService_panier produitServicePanier = new ProduitService_panier();
        produitServicePanier.setQuantite(panierRequestDto.getQuantite());
        produitServicePanier.setTotal((long) (produitService.getPrixVente() * panierRequestDto.getQuantite()));
        produitServicePanier.setPanier(client.getPanier());
        produitServicePanier.setProduitService(produitService);
        produitService.setStock(produitService.getStock() - panierRequestDto.getQuantite());
        produitServicePanierRepository.save(produitServicePanier);
        return null;
    }
}
