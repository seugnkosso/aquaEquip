import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { CategorieList } from '../../models/categorieliste';
import { RestResponse } from '../../models/rest.response';
import { CategorieService } from '../categorie.service';

@Injectable({
  providedIn: 'root',
})
export class CategorieServiceImpl implements CategorieService {
  apiUrl = `${environment.APIURL}/categorieProduits`;
  constructor(private http: HttpClient) {}
  findAll(): Observable<RestResponse<CategorieList[]>> {
    return this.http.get<RestResponse<CategorieList[]>>(`${this.apiUrl}`);
  }
}
