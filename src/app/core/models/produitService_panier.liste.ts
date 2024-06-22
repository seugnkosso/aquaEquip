export interface ProduitService_panierList {
  idProduit?: number;
  libelle?: string;
  photos?: string;
  stock?: number;
  prixAchat?: number;
  prixVente?: number;
  description?: string;
  idPanier: number;
  total: number;
  quantite: number;
}
