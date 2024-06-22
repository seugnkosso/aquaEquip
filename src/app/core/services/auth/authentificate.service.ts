import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import {
  AuthentificationRequest,
  InscriptionClient,
  TokenResponse,
} from '../../models/login.model';
import { RestResponse } from '../../models/rest.response';

@Injectable({
  providedIn: 'root',
})
export class AuthentificateService {
  isAuthentificated?: boolean;
  private apiUrl = `${environment.APIURL}/login`;
  constructor(private http: HttpClient) {}
  login(
    data: AuthentificationRequest
  ): Observable<RestResponse<TokenResponse>> {
    return this.http.post<RestResponse<TokenResponse>>(this.apiUrl, data);
  }
  inscritClient(data: InscriptionClient) {
    return this.http.post<RestResponse<TokenResponse>>(
      `${this.apiUrl}/client/inscrit`,
      data
    );
  }
  authentification() {
    return localStorage.getItem('connecter') === 'true';
  }
}
