package com.example.aquaEquip.data.repositories;

import com.example.aquaEquip.data.entities.Client;
import com.example.aquaEquip.data.entities.ProduitService_panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitService_panierRepository extends JpaRepository<ProduitService_panier,Long> {
    List<ProduitService_panier> findAllByPanierId(Long idPanier);

}
