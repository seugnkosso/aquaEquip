export interface ProduitServiceCreate {
  produitSelect?: string | null;
  libelle?: string | null;
  description?: string | null;
  prixAchat?: number | null;
  prixVente?: number | null;
  stock?: number | null;
  photo1?: string | null;
  photo2?: string | null;
  photo3?: string | null;
  categorie?: string | null;
}
