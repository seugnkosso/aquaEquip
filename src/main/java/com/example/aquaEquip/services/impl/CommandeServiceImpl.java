package com.example.aquaEquip.services.impl;

import com.example.aquaEquip.data.entities.Client;
import com.example.aquaEquip.data.entities.Commande;
import com.example.aquaEquip.data.entities.ProduitService_panier;
import com.example.aquaEquip.data.entities.VC_produitService;
import com.example.aquaEquip.data.repositories.*;
import com.example.aquaEquip.services.CommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandeServiceImpl implements CommandeService {
    private final ClientRepository clientRepository;
    private final CommandeRepository commandeRepository;
    private final ProduitService_panierRepository produitServicePanierRepository;
    private final VC_ProduitServiceRepository vcProduitServiceRepository;

    @Override
    public Commande addCommande(Long idClient) {
        Client client = clientRepository.findById(idClient).get();
        Commande commande = new Commande();
        Double total = Double.valueOf(0);
        for (ProduitService_panier p : client.getPanier().getListeproduitService_panier()){
            total = total + p.getTotal();
        }
        commande.setClient(client);
        commande.setTotal(total);
        commandeRepository.save(commande);
        List<VC_produitService> vcProduitServiceList = new ArrayList<>();
        for (ProduitService_panier p : client.getPanier().getListeproduitService_panier()){
            VC_produitService vcProduitService = new VC_produitService();
            vcProduitService.setVC(commande);
            vcProduitService.setTotal(Double.valueOf(p.getTotal()));
            vcProduitService.setProduitService(p.getProduitService());
            vcProduitService.setQte(p.getQuantite());
            vcProduitServiceList.add(vcProduitService);
        }
        vcProduitServiceRepository.saveAll(vcProduitServiceList);
        produitServicePanierRepository.deleteAll(client.getPanier().getListeproduitService_panier());
        return null;
    }

    @Override
    public Page<Commande> getAllCommandeByClientId(Long idClient, Pageable pageable) {
        return commandeRepository.findAllByClientId(idClient, pageable);
    }
}
