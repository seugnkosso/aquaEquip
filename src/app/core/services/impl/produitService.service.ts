import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { ProduitAVendreList } from '../../models/produitAVendre.liste';
import { ProduitServiceCreate } from '../../models/produitService.liste';
import { RestResponse } from '../../models/rest.response';
import { ProduitServiceService } from '../prosuitService.service';

@Injectable({
  providedIn: 'root',
})
export class ProduitServiceServiceImpl implements ProduitServiceService {
  apiUrl = `${environment.APIURL}/produitServices`;
  constructor(private http: HttpClient) {}
  findById(idProf: string): Observable<RestResponse<ProduitAVendreList>> {
    return this.http.get<RestResponse<ProduitAVendreList>>(
      `${this.apiUrl}/${idProf}`
    );
  }
  saveFile(formData: FormData): Observable<RestResponse<ProduitAVendreList>> {
    return this.http.post<RestResponse<ProduitAVendreList>>(
      `${this.apiUrl}/upload`,
      formData
    );
  }
  findAll(
    page: number = 0,
    libelle: string
  ): Observable<RestResponse<ProduitAVendreList[]>> {
    return this.http.get<RestResponse<ProduitAVendreList[]>>(
      `${this.apiUrl}?page=${page}&libelle=${libelle}`
    );
  }
  create(
    produitServiceCreate: ProduitServiceCreate
  ): Observable<RestResponse<ProduitAVendreList>> {
    return this.http.post<RestResponse<ProduitAVendreList>>(
      `${this.apiUrl}`,
      produitServiceCreate
    );
  }
}
