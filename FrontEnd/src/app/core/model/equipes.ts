import { Encadrant } from './encadrant';
import { DetailEquipe } from './detailEquipe';
import { Etudiant } from 'src/app/core/model/etudiant';
import { Projets } from './projets';
export class Equipes {
  encadrant: null;
  idEquipe: number;
  nomEquipe: String;
  niveau: String;
  detailEquipe: DetailEquipe[];
  photos: String;
  rating: number;
  encadrants: Encadrant;
  projets: Projets[];
  detailsEquipe: number;
  etudiants: Etudiant[];
}
