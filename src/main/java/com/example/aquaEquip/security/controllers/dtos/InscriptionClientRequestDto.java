package com.example.aquaEquip.security.controllers.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class InscriptionClientRequestDto {
    private String nomComplet;
    private String email;
    private String telephone;
    private String username;
    private String password;
}
