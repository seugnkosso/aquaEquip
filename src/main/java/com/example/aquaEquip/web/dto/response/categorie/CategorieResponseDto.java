package com.example.aquaEquip.web.dto.response.categorie;

import com.example.aquaEquip.data.entities.CategorieProduit;
import com.example.aquaEquip.data.entities.ProduitALouer;
import com.example.aquaEquip.data.entities.ProduitAVendre;
import com.example.aquaEquip.data.entities.Service;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategorieResponseDto {
    private Long id;
    private String libelle;

    public static CategorieResponseDto toDto(CategorieProduit categorieProduit) {
        return CategorieResponseDto.builder()
                .id(categorieProduit.getId())
                .libelle(categorieProduit.getLibelle())
                .build();
    }
}