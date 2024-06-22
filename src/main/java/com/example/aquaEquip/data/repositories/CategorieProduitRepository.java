package com.example.aquaEquip.data.repositories;

import com.example.aquaEquip.data.entities.CategorieProduit;
import com.example.aquaEquip.data.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieProduitRepository extends JpaRepository<CategorieProduit,Long> {
}
