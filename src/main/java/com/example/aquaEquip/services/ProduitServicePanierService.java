package com.example.aquaEquip.services;


import com.example.aquaEquip.data.entities.ProduitService_panier;

import java.util.List;

public interface ProduitServicePanierService {
    List<ProduitService_panier> getAllProduitServicePanierByClient(Long idClient);
}
