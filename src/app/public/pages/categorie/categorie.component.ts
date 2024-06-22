import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { ListProduitComponent } from '../../../core/component/list-produit/list-produit.component';
import { PaginationComponent } from '../../../core/component/pagination/pagination.component';
import { CategorieList } from '../../../core/models/categorieliste';
import { PaginationModel } from '../../../core/models/pagination.model';
import { ProduitAVendreList } from '../../../core/models/produitAVendre.liste';
import { CategorieServiceImpl } from '../../../core/services/impl/categorie.service';
import { ProduitAVendreServiceImpl } from '../../../core/services/impl/produitAVendre.service';

@Component({
  selector: 'app-categorie',
  standalone: true,
  imports: [RouterLink, ListProduitComponent, PaginationComponent],
  templateUrl: './categorie.component.html',
  styleUrl: './categorie.component.css',
})
export class CategorieComponent implements OnInit {
  resultsProdAVendre?: ProduitAVendreList[];
  resultsProdALouer?: ProduitAVendreList[];
  resultsService?: ProduitAVendreList[];
  idCategorie?: string = '0';
  categories?: CategorieList[];
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
  constructor(
    private categorieService: CategorieServiceImpl,
    private produitService: ProduitAVendreServiceImpl,
    private route: ActivatedRoute,
    private router: Router
  ) {}
  OnClick(id: number) {
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.router.navigate(['/public/categorie/' + id]);
    });
  }
  ngOnInit(): void {
    this.idCategorie = this.route.snapshot.paramMap.get('idCategorie')!;
    this.categorieService.findAll().subscribe((res) => {
      this.categories = res.results;
    });
    this.refresh();
  }
  refresh(
    pageAV: number = 0,
    pageAL: number = 0,
    pageSer: number = 0,
    libelle: string = ''
  ) {
    this.produitService
      .findAll(pageAV, libelle, this.idCategorie)
      .subscribe((res) => {
        this.resultsProdAVendre = res.results!;
        this.dataPaginationAV.pages = res.pages!;
        this.dataPaginationAV.currentPage = res.currentPage!;
      });
    this.produitService
      .findAllALouer(pageAL, libelle, this.idCategorie)
      .subscribe((res) => {
        this.resultsProdALouer = res.results!;
        this.dataPaginationAL.pages = res.pages!;
        this.dataPaginationAL.currentPage = res.currentPage!;
      });
    this.produitService
      .findAllService(pageSer, libelle, this.idCategorie)
      .subscribe((res) => {
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
