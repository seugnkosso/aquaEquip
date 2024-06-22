import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProduitsComponent } from './pages/produits/produits.component';

const routes: Routes = [
  {
    path: 'produit',
    children: [
      {
        path: '',
        component: ProduitsComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AdminRoutingModule {}
