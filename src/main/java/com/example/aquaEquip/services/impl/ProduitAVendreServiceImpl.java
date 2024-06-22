package com.example.aquaEquip.services.impl;

import com.example.aquaEquip.data.entities.ProduitAVendre;
import com.example.aquaEquip.data.repositories.ProduitAVendreRepository;
import com.example.aquaEquip.services.ProduitAVendreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProduitAVendreServiceImpl implements ProduitAVendreService {
    private final ProduitAVendreRepository produitAVendreRepository;
    @Override
    public Page<ProduitAVendre> getAllByLibelleAndCategori(String libelle,Long idCategori, Pageable pageable) {
        if(idCategori != 0){
            return produitAVendreRepository.findAllLibelleCategorieProduitId(libelle,idCategori,pageable);
        }else{
            return produitAVendreRepository.findAllByLibelleContains(libelle,pageable);
        }
    }
}
