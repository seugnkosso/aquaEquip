import { Observable } from 'rxjs';
import { CategorieList } from '../models/categorieliste';
import { RestResponse } from '../models/rest.response';

export interface CategorieService {
  findAll(): Observable<RestResponse<CategorieList[]>>;
}
