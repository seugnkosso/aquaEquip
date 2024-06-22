package com.example.aquaEquip.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vC_produitService")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VC_produitService extends AbstractEntity {
    private Long qte;
    private Double total;
    @ManyToOne
    private VC VC;
    @ManyToOne
    private ProduitService produitService;

}
