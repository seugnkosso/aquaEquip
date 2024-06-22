package com.example.aquaEquip.data.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "commande")
//@AllArgsConstructor
@NoArgsConstructor
@Data
@DiscriminatorValue("commande")
public class Commande extends VC {
    
}
