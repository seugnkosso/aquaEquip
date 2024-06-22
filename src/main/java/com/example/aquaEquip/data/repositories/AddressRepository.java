package com.example.aquaEquip.data.repositories;

import com.example.aquaEquip.data.entities.Address;
import com.example.aquaEquip.data.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    @Query("select a from Address a join a.listeClients cl where cl.id = :idClient")
    Address findByIdClient(@Param("idClient") Long idClient);
}
