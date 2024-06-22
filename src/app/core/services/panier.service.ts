import { Observable } from 'rxjs';
import { PanierAdd } from '../models/panier.liste';
import { RestResponse } from '../models/rest.response';

export interface PanierService {
  addPanier(
    PanierAdd: PanierAdd
  ): Observable<RestResponse<PanierAdd>>;
}
