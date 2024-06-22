package com.example.aquaEquip.data.entities;

import com.example.aquaEquip.security.data.entities.AppUser;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address extends AbstractEntity {
    private String ville;
    private String quartier;
    private String numVilla;
    @OneToMany(mappedBy = "address")
    private List<Client> listeClients;
}
