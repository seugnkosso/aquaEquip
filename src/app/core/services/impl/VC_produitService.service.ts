import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { ProduitService_panierList } from '../../models/produitService_panier.liste';
import { RestResponse } from '../../models/rest.response';
import { VC_ProduitServiceService } from '../VC_prosuitService.service';

@Injectable({
  providedIn: 'root',
})
export class VC_ProduitServiceServiceImpl implements VC_ProduitServiceService {
  apiUrl = `${environment.APIURL}/VC_produitServices`;
  constructor(private http: HttpClient) {}
  findAllByidCommande(
    idCommande: string
  ): Observable<RestResponse<ProduitService_panierList[]>> {
    return this.http.get<RestResponse<ProduitService_panierList[]>>(
      `${this.apiUrl}/Commande?idCommande=${idCommande}`
    );
  }
}
