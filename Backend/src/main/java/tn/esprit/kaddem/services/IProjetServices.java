package tn.esprit.kaddem.services;

import tn.esprit.kaddem.entities.Projet;

import java.util.List;

public interface IProjetServices {
    List<Projet> getAllProjet();

    Projet addProjet(Projet p ,Long id);

    Projet updateProjet(Projet p,int id2);

    Projet statusToFinished(Projet p);

    void deleteProjet(Long idProjet);

    Projet getProjet(Long idProjet);

    Projet addAndAssignProjetToEquipe(Projet p, int idEquipe);

    List<Projet> getProjetOfYear(int y);

    List<Projet> getProjetOrdredBYDateFin();

    double getPrixParEntreprise(Long idEntreprise);

    List<Object> getmapPrixForEntreprise();

    void majorationProjet();

}