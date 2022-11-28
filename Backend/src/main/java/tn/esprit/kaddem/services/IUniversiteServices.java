package tn.esprit.kaddem.services;

import tn.esprit.kaddem.entities.Universite;

import java.util.List;

public interface IUniversiteServices {

    List<Universite> getAllUniversites();

    Universite addUniversite(Universite u);

    Universite updateUniversite(Universite u);

    void deleteUniversite(Integer idUniversite);

    Universite getUniversite(Integer idUniversite);

    void assignUniversiteToDepartement(Integer idDepartement, Integer idUniversite);
}

