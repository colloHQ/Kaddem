package tn.esprit.kaddem.services;

import tn.esprit.kaddem.entities.Projet;

import java.util.List;

public interface IProjetServices {
    List<Projet> getAllProjet();

    Projet addProjet(Projet p);

    Projet updateProjet(Projet p);

    void deleteProjet(Long idProjet);

    Projet getProjet(Long idProjet);

    Projet addAndAssignProjetToEquipeAndEntreprise(Projet p, int idEquipe, Long idEntreprise);

    List<Projet> getProjetOfYear(int y);

    Projet getProjetOrdredBYDateFin();

}