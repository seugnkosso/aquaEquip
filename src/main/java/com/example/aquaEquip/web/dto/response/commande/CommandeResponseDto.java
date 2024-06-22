package com.example.aquaEquip.web.dto.response.commande;

import com.example.aquaEquip.data.entities.Address;
import com.example.aquaEquip.data.entities.Commande;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CommandeResponseDto {
    private Long id;
    private String total;
    private String date;
    private String client;

    public static CommandeResponseDto toDto(Commande commande) {
            return CommandeResponseDto.builder()
                    .id(commande.getId())
                    .total(String.valueOf(commande.getTotal()))
                    .date(commande.getDate().toString())
                    .client(commande.getClient().getNomComplet() +" | "+commande.getClient().getTelephone())
                    .build();
    }
}