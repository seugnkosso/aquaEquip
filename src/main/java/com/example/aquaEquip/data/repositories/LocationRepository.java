package com.example.aquaEquip.data.repositories;

import com.example.aquaEquip.data.entities.Client;
import com.example.aquaEquip.data.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {
}
