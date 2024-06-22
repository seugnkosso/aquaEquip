package com.example.aquaEquip.services.impl;

import com.example.aquaEquip.data.entities.Address;
import com.example.aquaEquip.data.repositories.AddressRepository;
import com.example.aquaEquip.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private  final AddressRepository addressRepository;
    @Override
    public Address getAddressByidClienf(Long idClient) {
        return addressRepository.findByIdClient(idClient);
    }
}
