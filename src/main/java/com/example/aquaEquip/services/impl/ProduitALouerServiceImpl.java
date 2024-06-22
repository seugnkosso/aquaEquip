package com.example.aquaEquip.services.impl;

import com.example.aquaEquip.data.entities.ProduitALouer;
import com.example.aquaEquip.data.repositories.ProduitALouerRepository;
import com.example.aquaEquip.services.ProduitALouerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProduitALouerServiceImpl implements ProduitALouerService {
    private final ProduitALouerRepository produitALouerRepository;
    @Override
    public Page<ProduitALouer> getAllByLibelleAndCategori(String libelle,Long idCategori, Pageable pageable) {
        if(idCategori != 0){
        return produitALouerRepository.findAllLibelleCategorieProduitId(libelle,idCategori,pageable);
        }else{
        return produitALouerRepository.findAllByLibelleContains(libelle,pageable);
        }

    }
}
