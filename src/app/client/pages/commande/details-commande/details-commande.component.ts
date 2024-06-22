import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { ProduitService_panierList } from '../../../../core/models/produitService_panier.liste';
import { VC_ProduitServiceServiceImpl } from '../../../../core/services/impl/VC_produitService.service';

@Component({
  selector: 'app-details-commande',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './details-commande.component.html',
  styleUrl: './details-commande.component.css',
})
export class DetailsCommandeComponent implements OnInit {
  listProduits?: ProduitService_panierList[];
  totalCommandes = 0;
  idCommande?: string;
  constructor(
    private VC_produitService: VC_ProduitServiceServiceImpl,
    private route: ActivatedRoute
  ) {}
  ngOnInit(): void {
    this.idCommande = this.route.snapshot.paramMap.get('idCommande')!;
    this.refresh();
  }
  refresh() {
    this.VC_produitService.findAllByidCommande(this.idCommande!).subscribe(
      (data) => {
        this.listProduits = data.results;
        for (let index = 0; index < this.listProduits!.length; index++) {
          this.totalCommandes += this.listProduits![index].total;
        }
      }
    );
  }
}
