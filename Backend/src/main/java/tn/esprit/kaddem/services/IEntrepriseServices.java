package tn.esprit.kaddem.services;

import tn.esprit.kaddem.entities.Entreprise;

import java.util.List;

public interface IEntrepriseServices {

    List<Entreprise> getAllEntreprise();

    Entreprise addEntreprise(Entreprise e);

    Entreprise updateEntreprise(Entreprise e);

    void deleteEntreprise(Long id);

    Entreprise getEntrepriseById(Long id);
}