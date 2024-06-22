package com.example.aquaEquip.services;


import com.example.aquaEquip.data.entities.ProduitService;
import com.example.aquaEquip.web.dto.request.produitService.ProduitServiceRequestDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProduitServiceService {
    ProduitService creatProduitService(ProduitServiceRequestDto produitServiceRequestDto);

    ProduitService findById(Long idProduit);

}
