import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { ProduitService_panierList } from '../../models/produitService_panier.liste';
import { RestResponse } from '../../models/rest.response';
import { ProduitService_panierService } from '../prosuitService_panier.service';

@Injectable({
  providedIn: 'root',
})
export class ProduitService_panierServiceImpl
  implements ProduitService_panierService
{
  apiUrl = `${environment.APIURL}/produitServices_panier`;
  constructor(private http: HttpClient) {}
  findAllByidClient(
    idCielnt: string
  ): Observable<RestResponse<ProduitService_panierList[]>> {
    return this.http.get<RestResponse<ProduitService_panierList[]>>(
      `${this.apiUrl}?idClient=${idCielnt}`
    );
  }
}
