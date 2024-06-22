import { inject } from '@angular/core';
import { Routes } from '@angular/router';
import { LayoutComponent } from './admin/layout/layout.component';
import { LayoutClientComponent } from './client/layout-client/layout-client.component';
import { IdentifyService } from './core/services/auth/identify.service';
import { LayoutPublicComponent } from './public/layout-public/layout-public.component';
import { LoginComponent } from './public/pages/login/login.component';

export const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'admin',
    component: LayoutComponent,
    loadChildren: () =>
      import('./admin/admin.module').then((mod) => mod.AdminModule),
    canMatch: [() => inject(IdentifyService).AdminIsIdentified()],
  },
  {
    path: 'client',
    component: LayoutClientComponent,
    loadChildren: () =>
      import('./client/client.module').then((mod) => mod.ClientModule),
    canMatch: [() => inject(IdentifyService).ClientIsIdentified()],
  },
  {
    path: 'public',
    component: LayoutPublicComponent,
    loadChildren: () =>
      import('./public/public.module').then((mod) => mod.PublicModule),
  },
  {
    path: '',
    redirectTo: '/public/accueil',
    pathMatch: 'full',
  },
  {
    path: '**',
    component: LoginComponent, //pageNotFound Component
  },
];
