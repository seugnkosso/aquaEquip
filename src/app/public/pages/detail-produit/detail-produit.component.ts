import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProduitAVendreList } from '../../../core/models/produitAVendre.liste';
import { RestResponse } from '../../../core/models/rest.response';
import { PanierServiceImpl } from '../../../core/services/impl/panier.service';
import { ProduitServiceServiceImpl } from '../../../core/services/impl/produitService.service';

@Component({
  selector: 'app-detail-produit',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './detail-produit.component.html',
  styleUrl: './detail-produit.component.css',
})
export class DetailProduitComponent implements OnInit {
  tofPrincipal = 0;
  response?: RestResponse<ProduitAVendreList>;
  idProd?: string;
  form = this.fb.group({
    idProduit: [''],
    idClient: [localStorage.getItem('idUser')],
    quantite: [1],
  });
  constructor(
    private produitService: ProduitServiceServiceImpl,
    private panierService: PanierServiceImpl,
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.idProd = this.route.snapshot.paramMap.get('idProduit')!;
    this.refresh();
  }
  refresh() {
    this.produitService.findById(this.idProd!).subscribe((res) => {
      this.response = res;
    });
  }
  changePricipaletof(tofPrice: number) {
    this.tofPrincipal = tofPrice;
  }
  addPanier() {
    const data = this.form.value;
    data.idProduit = this.idProd!;
    console.log(data);
    if (localStorage.getItem('idUser') != undefined) {
      this.panierService.addPanier(data).subscribe((res) => {
        if (res.status == 200) {
          window.location.reload();
        }
      });
    } else {
      this.router.navigateByUrl('/login');
    }
  }
}
