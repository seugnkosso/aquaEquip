import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { CategorieList } from '../../../core/models/categorieliste';
import { CategorieServiceImpl } from '../../../core/services/impl/categorie.service';

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css',
})
export class MenuComponent implements OnInit {
  categories?: CategorieList[];
  idUser = localStorage.getItem('idUser');
  constructor(
    private categorieService: CategorieServiceImpl,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.refresh();
  }
  refresh() {
    this.categorieService.findAll().subscribe((res) => {
      this.categories = res.results!;
    });
  }
  OnClick(id: number) {
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.router.navigate(['/public/categorie/' + id]);
    });
  }
}
