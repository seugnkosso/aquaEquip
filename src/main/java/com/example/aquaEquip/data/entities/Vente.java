package com.example.aquaEquip.data.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vente")
//@AllArgsConstructor
@NoArgsConstructor
@Data
@DiscriminatorValue("vente")
public class Vente extends VC {
    
}
