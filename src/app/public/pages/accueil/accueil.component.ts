import { Component, OnInit } from '@angular/core';
import { ListProduitComponent } from '../../../core/component/list-produit/list-produit.component';
import { PaginationModel } from '../../../core/models/pagination.model';
import { ProduitAVendreList } from '../../../core/models/produitAVendre.liste';
import { ProduitAVendreServiceImpl } from '../../../core/services/impl/produitAVendre.service';

@Component({
  selector: 'app-accueil',
  standalone: true,
  imports: [ListProduitComponent],
  templateUrl: './accueil.component.html',
  styleUrl: './accueil.component.css',
})
export class AccueilComponent implements OnInit {
  resultsProdAVendre?: ProduitAVendreList[];
  resultsProdALouer?: ProduitAVendreList[];
  resultsService?: ProduitAVendreList[];
  dataPaginationAV: PaginationModel = {
    pages: [],
    currentPage: 0,
  };
  dataPaginationAL: PaginationModel = {
    pages: [],
    currentPage: 0,
  };
  dataPaginationSE: PaginationModel = {
    pages: [],
    currentPage: 0,
  };
  constructor(private produitService: ProduitAVendreServiceImpl) {}

  ngOnInit(): void {
    this.refresh();
  }
  refresh(pageAV: number = 0, pageAL: number = 0, pageSer: number = 0) {
    this.produitService.findAll(pageAV, '', '0').subscribe((res) => {
      this.resultsProdAVendre = res.results!;
      this.dataPaginationAV.pages = res.pages!;
      this.dataPaginationAV.currentPage = res.currentPage!;
    });
    this.produitService.findAllALouer(pageAL, '', '0').subscribe((res) => {
      this.resultsProdALouer = res.results!;
      this.dataPaginationAL.pages = res.pages!;
      this.dataPaginationAL.currentPage = res.currentPage!;
    });
    this.produitService.findAllService(pageSer, '', '0').subscribe((res) => {
      this.resultsService = res.results!;
      this.dataPaginationSE.pages = res.pages!;
      this.dataPaginationSE.currentPage = res.currentPage!;
    });
  }
  OnPaginateAV(page: any) {
    this.refresh(
      page,
      this.dataPaginationAL.currentPage,
      this.dataPaginationSE.currentPage
    );
  }
  OnPaginateAL(page: any) {
    this.refresh(
      this.dataPaginationAV.currentPage,
      page,
      this.dataPaginationSE.currentPage
    );
  }
  OnPaginateSE(page: any) {
    this.refresh(
      this.dataPaginationAV.currentPage,
      this.dataPaginationAL.currentPage,
      page
    );
  }
}
