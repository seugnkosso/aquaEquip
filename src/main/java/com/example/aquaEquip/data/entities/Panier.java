package com.example.aquaEquip.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "panier")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Panier extends AbstractEntity {
    @OneToOne(mappedBy = "panier")
    private Client client;
    @OneToMany(mappedBy = "panier")
    private List<ProduitService_panier> listeproduitService_panier;
}
