import { Observable } from 'rxjs';
import { AddressList } from '../models/address.liste';
import { RestResponse } from '../models/rest.response';

export interface AddressService {
  findByIdClient(idClient: string): Observable<RestResponse<AddressList>>;
}
