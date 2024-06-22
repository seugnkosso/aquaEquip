package com.example.aquaEquip.data.repositories;

import com.example.aquaEquip.data.entities.Client;
import com.example.aquaEquip.data.entities.ProduitALouer;
import com.example.aquaEquip.data.entities.ProduitAVendre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitALouerRepository extends JpaRepository<ProduitALouer,Long> {

    Page<ProduitALouer> findAllByLibelleContains(String libelle, Pageable pageable);
    @Query("select p from ProduitALouer p join p.categorieProduit c where p.libelle like %:libelle% and c.id = :idCategorie ")
    Page<ProduitALouer> findAllLibelleCategorieProduitId(@Param("libelle") String libelle,@Param("idCategorie") Long idCategori, Pageable pageable);
}
