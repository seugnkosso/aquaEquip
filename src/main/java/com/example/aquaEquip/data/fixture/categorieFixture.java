package com.example.aquaEquip.data.fixture;

import com.example.aquaEquip.data.entities.CategorieProduit;
import com.example.aquaEquip.data.repositories.CategorieProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@Component
@RequiredArgsConstructor
public class categorieFixture implements CommandLineRunner {
    private final CategorieProduitRepository categorieProduitRepository;
    @Override
    public void run(String... args) throws Exception {
        List<CategorieProduit> categorieProduits = new ArrayList<>();
        categorieProduits.add(new CategorieProduit("BACS, BASSINS",null));
        categorieProduits.add(new CategorieProduit("VIVIERS",null));
        categorieProduits.add(new CategorieProduit("MATÉRIELS D'ÉCLOSERIE",null));
        categorieProduits.add(new CategorieProduit("SYSTÈME DE NOURRISSAGE",null));
        categorieProduits.add(new CategorieProduit("SYSTÈME D'AÉRATION",null));
        categorieProduits.add(new CategorieProduit("MATÉRIEL D'OXYGÉNATION",null));
        categorieProduits.add(new CategorieProduit("MATÉRIELS DE FILTRATION",null));
        categorieProduits.add(new CategorieProduit("COMPTEURS ET MARQUAGE",null));
        categorieProduits.add(new CategorieProduit("TRANSPORT DE POISSON",null));
        categorieProduits.add(new CategorieProduit("FILETS ET ÉPUISETTES",null));
        categorieProduits.add(new CategorieProduit("DISPOSITIF DE REFROIDISSEMENT ET CHAUFFAGE",null));
        categorieProduits.add(new CategorieProduit("POMPES ET MOTOPOMPES",null));
        categorieProduits.add(new CategorieProduit("VANNES ET RACCORDS",null));
        categorieProduits.add(new CategorieProduit("TRIEURS ET POMPES À POISSONS",null));
        categorieProduits.add(new CategorieProduit("NETTOYEURS",null));
        categorieProduits.add(new CategorieProduit("MATÉRIELS D'OCCASION",null));
        categorieProduits.add(new CategorieProduit("ÉCLAIRAGE",null));
        categorieProduits.add(new CategorieProduit("INSTRUMENTATION ET ANALYSES D'EAU",null));
        categorieProduits.add(new CategorieProduit("FILETS ET ÉPUISETTES",null));
        categorieProduits.add(new CategorieProduit("MATÉRIELS DE TRANSFORMATION",null));
        categorieProduitRepository.saveAll(categorieProduits);
    }
}
