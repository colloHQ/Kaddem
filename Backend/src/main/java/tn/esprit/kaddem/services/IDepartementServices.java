package tn.esprit.kaddem.services;

import tn.esprit.kaddem.entities.Departement;
import tn.esprit.kaddem.entities.Option;

import java.util.List;
import java.util.Set;

public interface IDepartementServices {

    List<Departement> getAllDepartements();

    Departement addDepartement(Departement d);

    Departement updateDepartement(Departement d);

    void deleteDepartement(Integer idDepart);

    Departement getDepartementById(Integer idDepart);

    List<Departement> retrieveDepartementByOptionEtudiant(Option op);

     Set<Departement> retrieveDepartementByUniversite(Integer idUniversite);


}
