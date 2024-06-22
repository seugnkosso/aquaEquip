package com.example.aquaEquip.services.impl;

import com.example.aquaEquip.data.entities.Service;
import com.example.aquaEquip.data.repositories.ServiceRepository;
import com.example.aquaEquip.services.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {
    private final ServiceRepository serviceRepository;
    @Override
    public Page<Service> getAllByLibelleAndCategori(String libelle,Long idCategori, Pageable pageable) {
        if(idCategori != 0){
            return serviceRepository.findAllLibelleCategorieProduitId(libelle,idCategori,pageable);
        }else{
            return serviceRepository.findAllByLibelleContains(libelle,pageable);
        }
    }
}
