package com.example.aquaEquip.data.repositories;

import com.example.aquaEquip.data.entities.Client;
import com.example.aquaEquip.data.entities.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long> {
    Page<Commande> findAllByClientId(Long idClient, Pageable pageable);
}
