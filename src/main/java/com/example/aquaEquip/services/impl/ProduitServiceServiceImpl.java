package com.example.aquaEquip.services.impl;

import com.example.aquaEquip.data.entities.CategorieProduit;
import com.example.aquaEquip.data.entities.ProduitALouer;
import com.example.aquaEquip.data.entities.ProduitAVendre;
import com.example.aquaEquip.data.entities.ProduitService;
import com.example.aquaEquip.data.repositories.*;
import com.example.aquaEquip.services.ProduitServiceService;
import com.example.aquaEquip.web.dto.request.produitService.ProduitServiceRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProduitServiceServiceImpl implements ProduitServiceService {
    private final ProduitAVendreRepository produitAVendreRepository;
    private final ProduitALouerRepository produitALouerRepository;
    private final ProduitServiceRepository produitServiceRepository;
    private final ServiceRepository serviceRepository;
    private final CategorieProduitRepository categorieProduitRepository;
    @Override
    public ProduitService creatProduitService(ProduitServiceRequestDto produitServiceRequestDto) {
        if(Objects.equals(produitServiceRequestDto.getProduitSelect(), "produitAVendre")){
            ProduitAVendre produitAVendre = getProduitAVendre(produitServiceRequestDto);
            produitAVendreRepository.save(produitAVendre);
        }else if(Objects.equals(produitServiceRequestDto.getProduitSelect(), "produitALouer")){
            ProduitALouer produitALouer = getProduitALouer(produitServiceRequestDto);
            produitALouerRepository.save(produitALouer);
        }else if(Objects.equals(produitServiceRequestDto.getProduitSelect(), "service")){
            com.example.aquaEquip.data.entities.Service Service = getService(produitServiceRequestDto);
            serviceRepository.save(Service);
        }
        return null;
    }

    @Override
    public ProduitService findById(Long idProduit) {
        return produitServiceRepository.findById(idProduit).get();
    }



    private  ProduitAVendre getProduitAVendre(ProduitServiceRequestDto produitServiceRequestDto) {
        ProduitAVendre produitAVendre = new ProduitAVendre();
        produitAVendre.setLibelle(produitServiceRequestDto.getLibelle());
        produitAVendre.setDescription(produitServiceRequestDto.getDescription());
        produitAVendre.setPrixAchat(produitServiceRequestDto.getPrixAchat());
        produitAVendre.setPrixVente(produitServiceRequestDto.getPrixVente());
        produitAVendre.setStock(produitServiceRequestDto.getStock());
        produitAVendre.setPhotos(produitServiceRequestDto.getPhoto1()+","+ produitServiceRequestDto.getPhoto2()+","+ produitServiceRequestDto.getPhoto3());
        produitAVendre.setCategorieProduit(categorieProduitRepository.findById(produitServiceRequestDto.getCategorie()).get());
        return produitAVendre;
    }

    private  ProduitALouer getProduitALouer(ProduitServiceRequestDto produitServiceRequestDto) {
        ProduitALouer produitALouer = new ProduitALouer();
        produitALouer.setLibelle(produitServiceRequestDto.getLibelle());
        produitALouer.setDescription(produitServiceRequestDto.getDescription());
        produitALouer.setPrixAchat(produitServiceRequestDto.getPrixAchat());
        produitALouer.setPrixVente(produitServiceRequestDto.getPrixVente());
        produitALouer.setStock(produitServiceRequestDto.getStock());
        produitALouer.setPhotos(produitServiceRequestDto.getPhoto1()+","+ produitServiceRequestDto.getPhoto2()+","+ produitServiceRequestDto.getPhoto3());
        produitALouer.setCategorieProduit(categorieProduitRepository.findById(produitServiceRequestDto.getCategorie()).get());
        return produitALouer;
    }

    private  com.example.aquaEquip.data.entities.Service getService(ProduitServiceRequestDto produitServiceRequestDto) {
        com.example.aquaEquip.data.entities.Service Service = new com.example.aquaEquip.data.entities.Service();
        Service.setLibelle(produitServiceRequestDto.getLibelle());
        Service.setDescription(produitServiceRequestDto.getDescription());
        Service.setPrixAchat(produitServiceRequestDto.getPrixAchat());
        Service.setPrixVente(produitServiceRequestDto.getPrixVente());
        Service.setStock(produitServiceRequestDto.getStock());
        Service.setPhotos(produitServiceRequestDto.getPhoto1()+","+ produitServiceRequestDto.getPhoto2()+","+ produitServiceRequestDto.getPhoto3());
        Service.setCategorieProduit(categorieProduitRepository.findById(produitServiceRequestDto.getCategorie()).get());
        return Service;
    }
}
