import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './pages/accueil/accueil.component';
import { CategorieComponent } from './pages/categorie/categorie.component';
import { DetailProduitComponent } from './pages/detail-produit/detail-produit.component';

const routes: Routes = [
  {
    path: 'accueil',
    children: [
      {
        path: '',
        component: AccueilComponent,
      },
    ],
  },
  {
    path: 'produit/detail/:idProduit',
    children: [
      {
        path: '',
        component: DetailProduitComponent,
      },
    ],
  },
  {
    path: 'categorie/:idCategorie',
    children: [
      {
        path: '',
        component: CategorieComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PublicRoutingModule {}
