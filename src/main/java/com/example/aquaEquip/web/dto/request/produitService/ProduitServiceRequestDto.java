package com.example.aquaEquip.web.dto.request.produitService;

import com.example.aquaEquip.data.entities.ProduitAVendre;
import com.example.aquaEquip.data.entities.ProduitService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProduitServiceRequestDto {
    private String produitSelect;
    private String libelle;
    private String description;
    private Double prixAchat;
    private Double prixVente;
    private Long stock;
    private String photo1;
    private String photo2;
    private String photo3;
    private Long categorie;
}
