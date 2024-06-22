package com.example.aquaEquip.data.repositories;

import com.example.aquaEquip.data.entities.ProduitService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitServiceRepository extends JpaRepository<ProduitService,Long> {

}
