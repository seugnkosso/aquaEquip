package com.example.aquaEquip.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "service")
@AllArgsConstructor
@NoArgsConstructor
@Data
@DiscriminatorValue("service")
public class Service extends ProduitService {
    @ManyToOne
    private VC VC;
    @ManyToOne
    private ProduitService produitService;
}
