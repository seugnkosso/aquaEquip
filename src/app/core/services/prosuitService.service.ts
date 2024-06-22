import { Observable } from 'rxjs';
import { ProduitAVendreList } from '../models/produitAVendre.liste';
import { ProduitServiceCreate } from '../models/produitService.liste';
import { RestResponse } from '../models/rest.response';

export interface ProduitServiceService {
  findAll(
    page: number,
    libelle: string
  ): Observable<RestResponse<ProduitAVendreList[]>>;
  findById(idProf: string): Observable<RestResponse<ProduitAVendreList>>;
  create(
    produitServiceCreate: ProduitServiceCreate
  ): Observable<RestResponse<ProduitAVendreList>>;
  saveFile(formData: FormData): Observable<RestResponse<ProduitAVendreList>>;
}
