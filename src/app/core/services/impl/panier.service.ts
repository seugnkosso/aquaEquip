import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { PanierAdd } from '../../models/panier.liste';
import { ProduitAVendreList } from '../../models/produitAVendre.liste';
import { RestResponse } from '../../models/rest.response';
import { PanierService } from '../panier.service';

@Injectable({
  providedIn: 'root',
})
export class PanierServiceImpl implements PanierService {
  apiUrl = `${environment.APIURL}/paniers`;
  constructor(private http: HttpClient) {}
  addPanier(PanierAdd: PanierAdd): Observable<RestResponse<PanierAdd>> {
    return this.http.post<RestResponse<PanierAdd>>(
      `${this.apiUrl}/add`,
      PanierAdd
    );
  }

  findById(idProf: string): Observable<RestResponse<ProduitAVendreList>> {
    return this.http.get<RestResponse<ProduitAVendreList>>(
      `${this.apiUrl}/${idProf}`
    );
  }
}
