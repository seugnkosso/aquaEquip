package com.example.aquaEquip.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produit_location")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class produit_location extends AbstractEntity {
    @ManyToOne
    private ProduitService produitService;
    @ManyToOne
    private Location location;
}
