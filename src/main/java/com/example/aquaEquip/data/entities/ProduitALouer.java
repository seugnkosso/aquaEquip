package com.example.aquaEquip.data.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produitALouer")
//@AllArgsConstructor
@NoArgsConstructor
@Data
@DiscriminatorValue("produitALouer")
public class ProduitALouer extends ProduitService {
    
}
