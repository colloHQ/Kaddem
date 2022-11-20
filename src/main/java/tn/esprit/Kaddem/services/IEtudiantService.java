package tn.esprit.Kaddem.services;

import tn.esprit.Kaddem.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> getAllEtudiant();

    Etudiant addEtudiant(Etudiant e);

    Etudiant updateEtudiant(Etudiant e);

    void deleteEtudiant(Long id);

    Etudiant getEtudiantById(Long id);

    Etudiant findByPrenomE(String prenomE);

}