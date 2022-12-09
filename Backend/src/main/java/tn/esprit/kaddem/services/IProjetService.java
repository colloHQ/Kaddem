package tn.esprit.kaddem.services;

import tn.esprit.kaddem.entities.Projet;
import tn.esprit.kaddem.entities.Universite;

import java.util.List;

public interface IProjetService {
    List<Projet> getAllProjet();

    Projet addProjet(Projet p);

    Projet updateProjet(Projet p);
    void deleteProjet(Long idProjet);

    Projet getProjet(Long idProjet);
    Projet addAndAssignProjetToEntreprise(Projet p,Long idEntreprise);
}
