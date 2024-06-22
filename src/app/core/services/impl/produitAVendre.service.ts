import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { ProduitAVendreList } from '../../models/produitAVendre.liste';
import { RestResponse } from '../../models/rest.response';
import { ProduitAVendreService } from '../prosuitAVendre.service';

@Injectable({
  providedIn: 'root',
})
export class ProduitAVendreServiceImpl implements ProduitAVendreService {
  apiUrl = `${environment.APIURL}/produitAVendres`;
  apiUrlAL = `${environment.APIURL}/produitALouers`;
  apiUrlS = `${environment.APIURL}/services`;
  constructor(private http: HttpClient) {}
  findAll(
    page: number = 0,
    libelle: string = '',
    categorieId: string = '0'
  ): Observable<RestResponse<ProduitAVendreList[]>> {
    return this.http.get<RestResponse<ProduitAVendreList[]>>(
      `${this.apiUrl}?page=${page}&libelle=${libelle}&idCategori=${categorieId}`
    );
  }
  findAllALouer(
    page: number = 0,
    libelle: string = '',
    categorieId: string = '0'
  ): Observable<RestResponse<ProduitAVendreList[]>> {
    return this.http.get<RestResponse<ProduitAVendreList[]>>(
      `${this.apiUrlAL}?page=${page}&libelle=${libelle}&idCategori=${categorieId}`
    );
  }
  findAllService(
    page: number = 0,
    libelle: string = '',
    categorieId: string = '0'
  ): Observable<RestResponse<ProduitAVendreList[]>> {
    return this.http.get<RestResponse<ProduitAVendreList[]>>(
      `${this.apiUrlS}?page=${page}&libelle=${libelle}&idCategori=${categorieId}`
    );
  }
}
