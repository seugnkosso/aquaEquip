package com.example.aquaEquip.services.impl;

import com.example.aquaEquip.data.entities.Client;
import com.example.aquaEquip.data.repositories.ClientRepository;
import com.example.aquaEquip.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    @Override
    public Client getClientByid(Long idClient) {
        return clientRepository.findById(idClient).get();
    }
}
