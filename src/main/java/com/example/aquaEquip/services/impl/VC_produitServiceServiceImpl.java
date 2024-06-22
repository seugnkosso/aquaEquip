package com.example.aquaEquip.services.impl;

import com.example.aquaEquip.data.entities.VC_produitService;
import com.example.aquaEquip.data.repositories.VC_ProduitServiceRepository;
import com.example.aquaEquip.services.VC_produitServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class VC_produitServiceServiceImpl implements VC_produitServiceService {
    private final VC_ProduitServiceRepository vcProduitServiceRepository;
    @Override
    public List<VC_produitService> getAllVC_produitService(Long idCommande) {
        return vcProduitServiceRepository.findAllByVCId(idCommande);
    }
}
