import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { AddressList } from '../../models/address.liste';
import { RestResponse } from '../../models/rest.response';
import { AddressService } from '../address.service';

@Injectable({
  providedIn: 'root',
})
export class AddressServiceImpl implements AddressService {
  apiUrl = `${environment.APIURL}/address`;
  constructor(private http: HttpClient) {}
  findByIdClient(idClient: string): Observable<RestResponse<AddressList>> {
    return this.http.get<RestResponse<AddressList>>(
      `${this.apiUrl}/client?idClient=${idClient}`
    );
  }
}
