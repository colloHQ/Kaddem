package tn.esprit.Kaddem.services;


import tn.esprit.Kaddem.entities.Departement;

import java.util.List;

public interface IDepartmentService {
    List<Departement> retrieveAllDepartements();

    Departement addDepartement(Departement d);

    Departement updateDepartement(Departement d);

    Departement retrieveDepartement(Integer idDepart);

    void removeDepartement(Integer idDepart);

    void assignEtudiantDepartement(Integer etudiantId, Integer departementId);

    void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);

    List<Departement> retrieveDepartementsByUniversite(Integer idDepartement);
}