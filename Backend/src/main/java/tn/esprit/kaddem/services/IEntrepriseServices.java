package tn.esprit.kaddem.services;

import tn.esprit.kaddem.entities.Entreprise;
import tn.esprit.kaddem.entities.Projet;
import tn.esprit.kaddem.entities.Review;

import java.util.List;

public interface IEntrepriseServices {

    List<Entreprise> getAllEntreprise();

    Entreprise addEntreprise(Entreprise e);

    Entreprise updateEntreprise(Entreprise e);

    void deleteEntreprise(Long id);

    Entreprise getEntrepriseById(Long id);

    Projet reviewProjet(Long idProjet, Review review);

    Entreprise getBestEntrepriseOfTheYear(int y);

}