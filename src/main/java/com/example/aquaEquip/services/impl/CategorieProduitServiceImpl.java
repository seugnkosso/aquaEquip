package com.example.aquaEquip.services.impl;

import com.example.aquaEquip.data.entities.CategorieProduit;
import com.example.aquaEquip.data.repositories.CategorieProduitRepository;
import com.example.aquaEquip.services.CategorieProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategorieProduitServiceImpl implements CategorieProduitService {
    private final CategorieProduitRepository categorieProduitRepository;
    @Override
    public List<CategorieProduit> getAll() {
        return categorieProduitRepository.findAll();
    }
}
