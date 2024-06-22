import { Observable } from 'rxjs';
import { ProduitService_panierList } from '../models/produitService_panier.liste';
import { RestResponse } from '../models/rest.response';

export interface VC_ProduitServiceService {
  findAllByidCommande(
    idCommande: string
  ): Observable<RestResponse<ProduitService_panierList[]>>;
}
