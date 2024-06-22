package com.example.aquaEquip.data.repositories;

import com.example.aquaEquip.data.entities.Client;
import com.example.aquaEquip.data.entities.VC_produitService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VC_ProduitServiceRepository extends JpaRepository<VC_produitService,Long> {
    List<VC_produitService> findAllByVCId(Long idCommande);
}
