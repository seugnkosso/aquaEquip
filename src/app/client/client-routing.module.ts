import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommandeComponent } from './pages/commande/commande.component';
import { DetailsCommandeComponent } from './pages/commande/details-commande/details-commande.component';
import { PanierComponent } from './pages/panier/panier.component';

const routes: Routes = [
  {
    path: 'panier',
    children: [
      {
        path: '',
        component: PanierComponent,
      },
    ],
  },
  {
    path: 'commande',
    children: [
      {
        path: '',
        component: CommandeComponent,
      },
    ],
  },
  {
    path: 'details-commande/:idCommande',
    children: [
      {
        path: '',
        component: DetailsCommandeComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ClientRoutingModule {}
