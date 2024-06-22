package com.example.aquaEquip.data.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produitAVendre")
//@AllArgsConstructor
@NoArgsConstructor
@Data
@DiscriminatorValue("produitAVendre")
public class ProduitAVendre extends ProduitService {
    
}
