import { CommonModule } from '@angular/common';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import {
  FormBuilder,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { CategorieList } from '../../../../core/models/categorieliste';
import { CategorieServiceImpl } from '../../../../core/services/impl/categorie.service';
import { ProduitServiceServiceImpl } from '../../../../core/services/impl/produitService.service';

@Component({
  selector: 'app-produits-form',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule, CommonModule],
  templateUrl: './produits-form.component.html',
  styleUrl: './produits-form.component.css',
})
export class ProduitsFormComponent implements OnInit {
  @Output() OnCloseForm: EventEmitter<any> = new EventEmitter();
  categories?: CategorieList[];
  form = this.fb.group({
    produitSelect: ['', [Validators.required]],
    libelle: ['', [Validators.required]],
    description: ['', [Validators.required]],
    prixAchat: [1, [Validators.min(1)]],
    prixVente: [1, [Validators.min(1)]],
    stock: [1, [Validators.min(1)]],
    photo1: ['', [Validators.required]],
    photo2: ['', [Validators.required]],
    photo3: ['', [Validators.required]],
    categorie: ['', [Validators.required]],
  });
  image1Select!: File;
  image2Select!: File;
  image3Select!: File;
  constructor(
    private fb: FormBuilder,
    private produitServiceService: ProduitServiceServiceImpl,
    private categorieService: CategorieServiceImpl,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.categorieService.findAll().subscribe((res) => {
      this.categories = res.results;
    });
  }
  closeForm() {
    this.OnCloseForm.emit();
  }
  onImage1Select(event: any) {
    this.image1Select = event.target.files[0];
  }
  onImage2Select(event: any) {
    this.image2Select = event.target.files[0];
  }
  onImage3Select(event: any) {
    this.image3Select = event.target.files[0];
  }

  onSubmit() {
    const produitServiceCreate = this.form.value;
    produitServiceCreate.photo1 = this.image1Select!.name;
    produitServiceCreate.photo2 = this.image2Select!.name;
    produitServiceCreate.photo3 = this.image3Select!.name;

    const formData = new FormData();
    formData.append('file1', this.image1Select!);
    formData.append('file2', this.image2Select!);
    formData.append('file3', this.image3Select!);

    this.produitServiceService.saveFile(formData).subscribe((data) => {
      this.produitServiceService
        .create(produitServiceCreate)
        .subscribe((data1) => {
          this.closeForm();
          this.router
            .navigateByUrl('/', { skipLocationChange: true })
            .then(() => {
              this.router.navigate(['/admin/produit']);
            });
        });
    });
  }
}
