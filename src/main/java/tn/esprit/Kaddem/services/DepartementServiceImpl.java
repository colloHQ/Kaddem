package tn.esprit.Kaddem.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Kaddem.entities.Departement;
import tn.esprit.Kaddem.entities.Etudiant;
import tn.esprit.Kaddem.repository.DepartementRepository;
import tn.esprit.Kaddem.repository.EtudiantRepository;

import java.util.List;

@Service
public class DepartementServiceImpl implements IDepartmentService {
    @Autowired
    DepartementRepository dr;
    @Autowired
    EtudiantRepository er;

    @Override
    public List<Departement> retrieveAllDepartements() {
        return dr.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return dr.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return dr.save(d);
    }

    @Override
    public Departement retrieveDepartement(Integer idDepart) {
        return dr.findById(idDepart).orElse(null);
    }

    @Override
    public void removeDepartement(Integer idDepart) {
        dr.deleteById(idDepart);

    }

    @Override
    public void assignEtudiantDepartement(Integer etudiantId, Integer departementId) {
        Etudiant e = er.findById(etudiantId.longValue()).orElse(null);
        Departement d = dr.findById(departementId).orElse(null);
        e.setDepartement(d);
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {

    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idDepartement) {
        return null;
    }
}