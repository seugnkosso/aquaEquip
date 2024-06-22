package com.example.aquaEquip.data.repositories;

import com.example.aquaEquip.data.entities.Client;
import com.example.aquaEquip.data.entities.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierRepository extends JpaRepository<Panier,Long> {
}
