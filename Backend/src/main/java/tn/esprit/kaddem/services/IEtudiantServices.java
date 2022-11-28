package tn.esprit.kaddem.services;


import tn.esprit.kaddem.entities.Etudiant;
import tn.esprit.kaddem.entities.Option;

import java.util.List;
import java.util.Set;

public interface IEtudiantServices {
    List<Etudiant> getALLEtudiant();

    Etudiant addEtudiant(Etudiant e);

    Etudiant updateEtudiant(Etudiant e);

    void deleteETudiant(Long id);

    Etudiant getEtudiantById(Long id);

    Etudiant getEtudiantbyPrenomEtudiant(String prenom);

    List<Etudiant> retrieveEtudiantByEquipeThematique(String thematique);

    void updateEtudiantByOption(Option op, Long idEtudiant);

    void assignEtudiantToDepartement(Long idEtudiant, Integer idDepartement);

    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);

    Set<Etudiant> getEtudiantByDepartement(Integer idDepartement);

}
