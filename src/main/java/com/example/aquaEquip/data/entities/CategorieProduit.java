package com.example.aquaEquip.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categorieProduit")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategorieProduit extends AbstractEntity {
    private String libelle;
    @OneToMany(mappedBy = "categorieProduit")
    private List<ProduitService> listeProduitServices;
}
