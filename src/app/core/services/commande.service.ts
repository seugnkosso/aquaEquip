import { Observable } from 'rxjs';
import { AddressList } from '../models/address.liste';
import { CommandeList } from '../models/commande.liste';
import { RestResponse } from '../models/rest.response';

export interface CommandeService {
  addCommande(idClient: string): Observable<RestResponse<AddressList>>;
  allCommandeClient(
    idClient: string,
    page: number
  ): Observable<RestResponse<CommandeList[]>>;
}
