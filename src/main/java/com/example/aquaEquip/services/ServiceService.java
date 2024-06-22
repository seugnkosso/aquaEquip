package com.example.aquaEquip.services;


import com.example.aquaEquip.data.entities.ProduitAVendre;
import com.example.aquaEquip.data.entities.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceService {
    Page<Service> getAllByLibelleAndCategori(String libelle,Long idCategori, Pageable pageable);

}
