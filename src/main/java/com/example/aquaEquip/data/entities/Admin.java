package com.example.aquaEquip.data.entities;

import com.example.aquaEquip.security.data.entities.AppUser;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin")
//@AllArgsConstructor
@NoArgsConstructor
@Data
@DiscriminatorValue("admin")
public class Admin extends AppUser {
}
