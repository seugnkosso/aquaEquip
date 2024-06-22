package com.example.aquaEquip.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "location")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Location extends AbstractEntity {
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut = new Date();
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFin;
    private Double Total;

    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "location")
    private List<produit_location> listeProduitLocations;
}
