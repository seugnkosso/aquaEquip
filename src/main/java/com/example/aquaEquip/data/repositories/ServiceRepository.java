package com.example.aquaEquip.data.repositories;

import com.example.aquaEquip.data.entities.Client;
import com.example.aquaEquip.data.entities.ProduitAVendre;
import com.example.aquaEquip.data.entities.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Long> {
    @Query("select s from Service s join s.categorieProduit c where s.libelle like %:libelle% and c.id = :idCategorie ")
    Page<Service> findAllLibelleCategorieProduitId(@Param("libelle") String libelle, @Param("idCategorie")Long idCategorie, Pageable pageable);
    Page<Service> findAllByLibelleContains(String libelle, Pageable pageable);
}
