package com.example.aquaEquip.web.dto.response.address;

import com.example.aquaEquip.data.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddressResponseDto {
    private String ville;
    private String quartier;
    private String numVilla;

    public static AddressResponseDto toDto(Address address) {
        if (address != null) {
            return AddressResponseDto.builder()
                    .ville(address.getVille())
                    .quartier(address.getQuartier())
                    .numVilla(address.getNumVilla())
                    .build();
        }
        return null;
    }
}