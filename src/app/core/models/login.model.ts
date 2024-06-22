export interface TokenResponse {
  id?: number;
  token: string;
  roles: String[];
}
export interface InscriptionClient {
  nomComplet?: string | null;
  email?: string | null;
  telephone?: string | null;
  username?: string | null;
  password?: string | null;
}

export interface AuthentificationRequest {
  username?: string | null;
  password?: string | null;
}
