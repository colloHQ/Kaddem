package tn.esprit.Kaddem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Kaddem.entities.Departement;
import tn.esprit.Kaddem.entities.Universite;
import tn.esprit.Kaddem.repository.DepartementRepository;
import tn.esprit.Kaddem.repository.UniversiteRepository;

import java.util.Date;
import java.util.List;

@Service
public class UniversiteServiceImpl implements IUniversiteService {
    @Autowired
    UniversiteRepository ur;
    @Autowired
    DepartementRepository dr;

    @Override
    public List<Universite> retrieveAllUniversites() {
        return ur.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        List<Departement> departementList = (List<Departement>) u.getDepartements();
        for (Departement departement : departementList) {
            dr.save(departement);
        }
        return ur.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return ur.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return ur.findById(idUniversite).orElse(null);
    }

    @Override
    public void removeUniversite(Integer idUniversite) {
        ur.deleteById(idUniversite);
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        return 0;
    }


}