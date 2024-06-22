package com.example.aquaEquip.data.entities;

import com.example.aquaEquip.security.data.entities.AppUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "client")
@AllArgsConstructor
@NoArgsConstructor
@Data
@DiscriminatorValue("Client")
public class Client extends AppUser {
    @ManyToOne
    private Address address;
    @OneToMany(mappedBy = "client")
    private List<Location> listeLocations;
    @OneToMany(mappedBy = "client")
    private List<VC> listeVC;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "panier_id", referencedColumnName = "id")
    private Panier panier;
}
