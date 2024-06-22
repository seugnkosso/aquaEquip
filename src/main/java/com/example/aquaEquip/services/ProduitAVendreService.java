package com.example.aquaEquip.services;


import com.example.aquaEquip.data.entities.ProduitAVendre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProduitAVendreService {
    Page<ProduitAVendre> getAllByLibelleAndCategori(String libelle,Long idCategori, Pageable pageable);
}
