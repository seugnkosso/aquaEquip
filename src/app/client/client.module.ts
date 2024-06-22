import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { FooterComponent } from '../core/component/footer/footer.component';
import { HeaderComponent } from '../core/component/header/header.component';
import { MenuComponent } from '../core/component/menu/menu.component';
import { ClientRoutingModule } from './client-routing.module';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { LayoutClientComponent } from './layout-client/layout-client.component';

@NgModule({
  declarations: [SidebarComponent, LayoutClientComponent],
  imports: [
    CommonModule,
    ClientRoutingModule,
    FooterComponent,
    MenuComponent,
    HeaderComponent,
  ],
})
export class ClientModule {}
