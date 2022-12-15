import { Departement } from 'src/app/univ-depart/model/departement';
import { Option } from './option';

export class Etudiant {
  idEtudiant: number;
  prenomEtudiant: String;
  nomEtudiant: String;
  option: Option;
  departement: Departement;
}
