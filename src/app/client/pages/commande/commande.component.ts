import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { PaginationComponent } from '../../../core/component/pagination/pagination.component';
import { CommandeList } from '../../../core/models/commande.liste';
import { PaginationModel } from '../../../core/models/pagination.model';
import { RestResponse } from '../../../core/models/rest.response';
import { CommandeServiceImpl } from '../../../core/services/impl/commande.service';

@Component({
  selector: 'app-commande',
  standalone: true,
  imports: [PaginationComponent, RouterLink],
  templateUrl: './commande.component.html',
  styleUrl: './commande.component.css',
})
export class CommandeComponent implements OnInit {
  listCommandes?: RestResponse<CommandeList[]>;
  dataPagination: PaginationModel = {
    pages: [],
    currentPage: 0,
  };
  constructor(private commandeService: CommandeServiceImpl) {}
  ngOnInit(): void {
    this.refresh();
  }
  refresh(page: number = 0) {
    this.commandeService
      .allCommandeClient(localStorage.getItem('idUser')!, page)
      .subscribe((data) => {
        this.listCommandes = data;
        this.dataPagination.pages = data.pages!;
        this.dataPagination.currentPage = data.currentPage!;
      });
  }
  paginate(page: number) {
    this.refresh(page);
  }
}
