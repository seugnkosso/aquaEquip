package com.example.aquaEquip.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produitService_panier")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProduitService_panier extends AbstractEntity {
    private Long quantite;
    private Long total;
    @ManyToOne
    private ProduitService produitService;
    @ManyToOne
    private Panier panier;
}
