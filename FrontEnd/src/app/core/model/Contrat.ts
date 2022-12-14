import { Etudiant } from './etudiant';
import { Specialite } from './Specialite';
export class Contrat {
  idContrat: number;
  archive: boolean;
  dateDebutContrat: Date;
  dateFinContrat: Date;
  specialite: Specialite;
  etudiant: Etudiant;
  constructor(
    idContrat: number,
    archive: boolean,
    dateDebutContrat: Date,
    dateFinContrat: Date,
    specialite: Specialite,
    etudiant: Etudiant
  ) {
    this.idContrat = idContrat;
    this.archive = archive;
    this.dateDebutContrat = dateDebutContrat;
    this.dateFinContrat = dateFinContrat;
    this.specialite = specialite;
    this.etudiant = etudiant;
  }
}
