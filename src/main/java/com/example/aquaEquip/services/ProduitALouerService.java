package com.example.aquaEquip.services;


import com.example.aquaEquip.data.entities.ProduitALouer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProduitALouerService {
    Page<ProduitALouer> getAllByLibelleAndCategori(String libelle,Long idCategori, Pageable pageable);
}
