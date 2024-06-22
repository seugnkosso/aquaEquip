import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { ReactiveFormsModule } from '@angular/forms';
import { FooterComponent } from '../core/component/footer/footer.component';
import { HeaderComponent } from '../core/component/header/header.component';
import { MenuComponent } from '../core/component/menu/menu.component';
import { LayoutPublicComponent } from './layout-public/layout-public.component';
import { LoginComponent } from './pages/login/login.component';
import { PublicRoutingModule } from './public-routing.module';

@NgModule({
  declarations: [LayoutPublicComponent, LoginComponent],
  imports: [
    CommonModule,
    PublicRoutingModule,
    ReactiveFormsModule,
    MenuComponent,
    FooterComponent,
    HeaderComponent,
  ],
})
export class PublicModule {}
