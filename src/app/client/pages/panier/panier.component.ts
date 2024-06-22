import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { ProduitService_panierList } from '../../../core/models/produitService_panier.liste';
import { CommandeServiceImpl } from '../../../core/services/impl/commande.service';
import { ProduitService_panierServiceImpl } from '../../../core/services/impl/produitService_panier.service';

@Component({
  selector: 'app-panier',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './panier.component.html',
  styleUrl: './panier.component.css',
})
export class PanierComponent implements OnInit {
  listProduits?: ProduitService_panierList[];
  totalCommandes = 0;
  constructor(
    private produitServicePanier: ProduitService_panierServiceImpl,
    private commandeService: CommandeServiceImpl
  ) {}
  ngOnInit(): void {
    this.refresh();
  }
  refresh() {
    this.produitServicePanier
      .findAllByidClient(localStorage.getItem('idUser')!)
      .subscribe((data) => {
        this.listProduits = data.results;
        for (let index = 0; index < this.listProduits!.length; index++) {
          this.totalCommandes += this.listProduits![index].total;
        }
      });
  }
  supprimer(arg0: any) {
    throw new Error('Method not implemented.');
  }
  commander() {
    this.commandeService
      .addCommande(localStorage.getItem('idUser')!)
      .subscribe((data) => {
        window.location.reload();
      });
  }
}
