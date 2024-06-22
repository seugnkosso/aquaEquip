package com.example.aquaEquip.services;


import com.example.aquaEquip.data.entities.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommandeService {
    Commande addCommande(Long  idClient);

    Page<Commande> getAllCommandeByClientId(Long idClient, Pageable pageable);
}
