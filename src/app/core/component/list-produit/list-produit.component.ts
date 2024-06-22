import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { PaginationModel } from '../../models/pagination.model';
import { ProduitAVendreList } from '../../models/produitAVendre.liste';
import { PanierServiceImpl } from '../../services/impl/panier.service';
import { PaginationComponent } from '../pagination/pagination.component';

@Component({
  selector: 'app-list-produit',
  standalone: true,
  imports: [PaginationComponent, RouterLink],
  templateUrl: './list-produit.component.html',
  styleUrl: './list-produit.component.css',
})
export class ListProduitComponent implements OnInit {
  @Output() OnPaginateAV: EventEmitter<any> = new EventEmitter();
  @Output() OnPaginateAL: EventEmitter<any> = new EventEmitter();
  @Output() OnPaginateSE: EventEmitter<any> = new EventEmitter();
  @Input({ required: true }) resultsProdAVendre?: ProduitAVendreList[];
  @Input({ required: true }) resultsProdALouer?: ProduitAVendreList[];
  @Input({ required: true }) resultsService?: ProduitAVendreList[];
  @Input({ required: true }) dataPagination: PaginationModel = {
    pages: [],
    currentPage: 0,
  };
  @Input({ required: true }) dataPaginationAL: PaginationModel = {
    pages: [],
    currentPage: 0,
  };
  @Input({ required: true }) dataPaginationSE: PaginationModel = {
    pages: [],
    currentPage: 0,
  };

  form = this.fb.group({
    idProduit: [''],
    idClient: [localStorage.getItem('idUser')],
    quantite: [1],
  });
  constructor(
    private router: Router,
    private fb: FormBuilder,
    private panierService: PanierServiceImpl
  ) {}
  ngOnInit(): void {}
  paginateAV(page: number) {
    this.OnPaginateAV.emit(page);
  }
  paginateAL(page: number) {
    this.OnPaginateAL.emit(page);
  }
  paginateSE(page: number) {
    this.OnPaginateSE.emit(page);
  }
  addPanier(id: number | undefined) {
    const data = this.form.value;
    data.idProduit = '' + id;
    if (localStorage.getItem('idUser') != undefined) {
      this.panierService.addPanier(data).subscribe((res) => {
        if (res.status == 200) {
        }
      });
    } else {
      this.router.navigateByUrl('/login');
    }
  }
}
