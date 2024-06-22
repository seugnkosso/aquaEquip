package com.example.aquaEquip.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "ProduitService")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@DiscriminatorValue(value = "produitService")
@Builder
public class ProduitService extends AbstractEntity {
    private String libelle;
    private String photos;
    private Long stock;
    private Double prixAchat;
    private Double prixVente;
    private String description;
    @ManyToOne
    private CategorieProduit categorieProduit;
    @OneToMany(mappedBy = "produitService")
    private List<VC_produitService> listeVC_ProduitServices;
    @OneToMany(mappedBy = "produitService")
    private List<ProduitService_panier> listeProduitService_paniers;
    @OneToMany(mappedBy = "produitService")
    private List<produit_location> listeproduit_locations;
}
