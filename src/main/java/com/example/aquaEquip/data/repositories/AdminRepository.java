package com.example.aquaEquip.data.repositories;

import com.example.aquaEquip.data.entities.Admin;
import com.example.aquaEquip.data.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
}
