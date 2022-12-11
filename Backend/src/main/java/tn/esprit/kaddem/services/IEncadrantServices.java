package tn.esprit.kaddem.services;

import java.util.List;

import tn.esprit.kaddem.entities.Encadrant;

public interface IEncadrantServices {
    
    List<Encadrant> getAllEncadrants();

    Encadrant addEncadrant(Encadrant en);

    Encadrant updateEncadrant(Encadrant en);

    void deleteEncadrant(Integer idEncadrant);

    Encadrant getEncadrantById(Integer idEncadrant);

    List<Encadrant> getEncadrantsByNiveauEquipe(String niveau);

    void addAndAssignEncadrantToEquipe(Integer idEquipe, Encadrant en);

}
