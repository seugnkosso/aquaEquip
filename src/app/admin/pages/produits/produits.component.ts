import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PaginationComponent } from '../../../core/component/pagination/pagination.component';
import { PaginationModel } from '../../../core/models/pagination.model';
import { ProduitAVendreList } from '../../../core/models/produitAVendre.liste';
import { RestResponse } from '../../../core/models/rest.response';
import { ProduitAVendreServiceImpl } from '../../../core/services/impl/produitAVendre.service';
import { ProduitsFormComponent } from './produits-form/produits-form.component';

@Component({
  selector: 'app-produits',
  standalone: true,
  imports: [
    CommonModule,
    PaginationComponent,
    FormsModule,
    ReactiveFormsModule,
    ProduitsFormComponent,
  ],
  templateUrl: './produits.component.html',
  styleUrl: './produits.component.css',
})
export class ProduitsComponent implements OnInit {
  [x: string]: any;
  response?: RestResponse<ProduitAVendreList[]>;
  dataPagination: PaginationModel = {
    pages: [],
    currentPage: 0,
  };
  form = this.fb.group({
    type: '',
  });
  assets: any;
  imageUpLoad: any;
  constructor(
    private fb: FormBuilder,
    private produitAVendreService: ProduitAVendreServiceImpl
  ) {}
  ngOnInit(): void {
    this.form.controls['type'].setValue('produitAVendre');
    this.refresh();
  }
  refresh(page: number = 0): void {
    if (this.form.controls['type'].value == 'produitAVendre') {
      this.produitAVendreService
        .findAll(page, '')
        .subscribe(
          (data) => (
            (this.response = data),
            (this.dataPagination.pages = data.pages!),
            (this.dataPagination.currentPage = data.currentPage!)
          )
        );
    }
    if (this.form.controls['type'].value == 'service') {
      this.produitAVendreService
        .findAllService(page, '')
        .subscribe(
          (data) => (
            (this.response = data),
            (this.dataPagination.pages = data.pages!),
            (this.dataPagination.currentPage = data.currentPage!)
          )
        );
    }
    if (this.form.controls['type'].value == 'produitALouer') {
      this.produitAVendreService
        .findAllALouer(page, '')
        .subscribe(
          (data) => (
            (this.response = data),
            (this.dataPagination.pages = data.pages!),
            (this.dataPagination.currentPage = data.currentPage!)
          )
        );
    }
  }

  OnTypeChange() {
    this.refresh();
  }
  paginate(page: number) {
    this.refresh(page);
  }

  // FORM ADD ON
  formIsClose = true;
  onOpenForm() {
    this.formIsClose = false;
  }
  closeForm() {
    this.formIsClose = true;
  }
  // FORM ADD OFF
}
