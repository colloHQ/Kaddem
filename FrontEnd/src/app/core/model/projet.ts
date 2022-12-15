import {Entreprise} from "./entreprise";
import {Equipes} from "./equipes";

export class Projet {
  idProjet: number;
  description: String;
  prixProjet:number;
  review: String;
  equipe:Equipes;
  entrepriseP: Entreprise;
  status:String;
  dateDebutProjet:Date;
  dateFinProjet:Date;
}

