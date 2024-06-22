package com.example.aquaEquip.web.dto.request.panier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PanierRequestDto {
   private Long idProduit;
   private Long idClient;
   private Long quantite;
}
