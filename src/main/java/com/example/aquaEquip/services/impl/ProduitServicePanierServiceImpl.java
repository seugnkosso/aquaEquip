package com.example.aquaEquip.services.impl;

import com.example.aquaEquip.data.entities.Client;
import com.example.aquaEquip.data.entities.ProduitService_panier;
import com.example.aquaEquip.data.repositories.ClientRepository;
import com.example.aquaEquip.data.repositories.ProduitService_panierRepository;
import com.example.aquaEquip.services.ProduitServicePanierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProduitServicePanierServiceImpl implements ProduitServicePanierService {
    private final ProduitService_panierRepository produitServicePanierRepository;
    private final ClientRepository clientRepository;
    @Override
    public List<ProduitService_panier> getAllProduitServicePanierByClient(Long idClient) {
        Client client = clientRepository.findById(idClient).get();
        return client.getPanier().getListeproduitService_panier();
    }
}
