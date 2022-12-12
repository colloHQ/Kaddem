package tn.esprit.kaddem.services;

import tn.esprit.kaddem.entities.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IEntrepriseServices {

    List<Entreprise> getAllEntreprise();

    Entreprise addEntreprise(Entreprise e);

    Entreprise updateEntreprise(Entreprise e);

    void deleteEntreprise(Long id);

    Entreprise getEntrepriseById(Long id);

    Projet reviewProjet(Long idProjet, Review review);

    Entreprise getBestEntrepriseOfTheYear(int y);

    String PourcentageDeparticipationSelonSecteur(Secteur secteur);

    List<Entreprise> findByProjetsIsNull();

    Map<String, Set<String>> GetAllEquipsOfAllEntreprises();

}