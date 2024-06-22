import { Observable } from 'rxjs';
import { ProduitService_panierList } from '../models/produitService_panier.liste';
import { RestResponse } from '../models/rest.response';

export interface ProduitService_panierService {
  findAllByidClient(
    idCielnt: string
  ): Observable<RestResponse<ProduitService_panierList[]>>;
}
