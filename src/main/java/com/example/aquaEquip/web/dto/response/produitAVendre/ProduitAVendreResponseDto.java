package com.example.aquaEquip.web.dto.response.produitAVendre;

import com.example.aquaEquip.data.entities.ProduitALouer;
import com.example.aquaEquip.data.entities.ProduitAVendre;
import com.example.aquaEquip.data.entities.ProduitService;
import com.example.aquaEquip.data.entities.Service;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProduitAVendreResponseDto {
    private Long id;
    private String libelle;
    private String photos;
    private Long stock;
    private Double prixAchat;
    private Double prixVente;
    private String description;

    public static ProduitAVendreResponseDto toDto(ProduitAVendre produitAVendre) {
        return ProduitAVendreResponseDto.builder()
                .id(produitAVendre.getId())
                .libelle(produitAVendre.getLibelle())
                .photos(produitAVendre.getPhotos())
                .stock(produitAVendre.getStock())
                .prixAchat(produitAVendre.getPrixAchat())
                .prixVente(produitAVendre.getPrixVente())
                .description(produitAVendre.getDescription())
                .build();
    }
    public static ProduitAVendreResponseDto prodServiceDto(ProduitService produitAVendre) {
        return ProduitAVendreResponseDto.builder()
                .id(produitAVendre.getId())
                .libelle(produitAVendre.getLibelle())
                .photos(produitAVendre.getPhotos())
                .stock(produitAVendre.getStock())
                .prixAchat(produitAVendre.getPrixAchat())
                .prixVente(produitAVendre.getPrixVente())
                .description(produitAVendre.getDescription())
                .build();
    }
    public static ProduitAVendreResponseDto ALouertoDto(ProduitALouer produitALouer) {
        return ProduitAVendreResponseDto.builder()
                .id(produitALouer.getId())
                .libelle(produitALouer.getLibelle())
                .photos(produitALouer.getPhotos())
                .stock(produitALouer.getStock())
                .prixAchat(produitALouer.getPrixAchat())
                .prixVente(produitALouer.getPrixVente())
                .description(produitALouer.getDescription())
                .build();
    }
    public static ProduitAVendreResponseDto ServicetoDto(Service service) {
        return ProduitAVendreResponseDto.builder()
                .id(service.getId())
                .libelle(service.getLibelle())
                .photos(service.getPhotos())
                .stock(service.getStock())
                .prixAchat(service.getPrixAchat())
                .prixVente(service.getPrixVente())
                .description(service.getDescription())
                .build();
    }

}
