import { Observable } from 'rxjs';
import { ProduitAVendreList } from '../models/produitAVendre.liste';
import { RestResponse } from '../models/rest.response';

export interface ProduitAVendreService {
  findAll(
    page: number,
    libelle: string,
    categorieId: string
  ): Observable<RestResponse<ProduitAVendreList[]>>;

  findAllALouer(
    page: number,
    libelle: string,
    categorieId: string
  ): Observable<RestResponse<ProduitAVendreList[]>>;
  findAllService(
    page: number,
    libelle: string,
    categorieId: string
  ): Observable<RestResponse<ProduitAVendreList[]>>;
}
