import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { AddressList } from '../../models/address.liste';
import { CommandeList } from '../../models/commande.liste';
import { RestResponse } from '../../models/rest.response';
import { CommandeService } from '../commande.service';

@Injectable({
  providedIn: 'root',
})
export class CommandeServiceImpl implements CommandeService {
  apiUrl = `${environment.APIURL}/commandes`;
  constructor(private http: HttpClient) {}
  allCommandeClient(
    idClient: string,
    page: number = 0
  ): Observable<RestResponse<CommandeList[]>> {
    return this.http.get<RestResponse<CommandeList[]>>(
      `${this.apiUrl}/all/client?idClient=${idClient}&page=${page}`
    );
  }
  addCommande(idClient: string): Observable<RestResponse<AddressList>> {
    return this.http.get<RestResponse<AddressList>>(
      `${this.apiUrl}/client?idClient=${idClient}`
    );
  }
}
