package com.example.aquaEquip.web.dto.response.produitServicePanier;

import com.example.aquaEquip.data.entities.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProduitService_panierResponseDto {
    private Long idProduit;
    private String libelle;
    private String photos;
    private Long stock;
    private Double prixAchat;
    private Double prixVente;
    private String description;
    private Long idPanier;
    private Double total;
    private Long quantite;

    public static ProduitService_panierResponseDto toDto(ProduitService_panier produitService_panier) {
        return ProduitService_panierResponseDto.builder()
                .idProduit(produitService_panier.getProduitService().getId())
                .libelle(produitService_panier.getProduitService().getLibelle())
                .photos(produitService_panier.getProduitService().getPhotos())
                .stock(produitService_panier.getProduitService().getStock())
                .prixAchat(produitService_panier.getProduitService().getPrixAchat())
                .prixVente(produitService_panier.getProduitService().getPrixVente())
                .description(produitService_panier.getProduitService().getDescription())
                .idPanier(produitService_panier.getPanier().getId())
                .total(Double.valueOf(produitService_panier.getTotal()))
                .quantite(produitService_panier.getQuantite())
                .build();
    }
    public static ProduitService_panierResponseDto toDtoVC(VC_produitService vcProduitService) {
        return ProduitService_panierResponseDto.builder()
                .idProduit(vcProduitService.getProduitService().getId())
                .libelle(vcProduitService.getProduitService().getLibelle())
                .photos(vcProduitService.getProduitService().getPhotos())
                .stock(vcProduitService.getProduitService().getStock())
                .prixAchat(vcProduitService.getProduitService().getPrixAchat())
                .prixVente(vcProduitService.getProduitService().getPrixVente())
                .description(vcProduitService.getProduitService().getDescription())
                .idPanier(vcProduitService.getVC().getId())
                .total(vcProduitService.getTotal())
                .quantite(vcProduitService.getQte())
                .build();
    }
}
