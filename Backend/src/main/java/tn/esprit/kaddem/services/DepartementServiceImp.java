package tn.esprit.kaddem.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entities.Departement;
import tn.esprit.kaddem.entities.Option;
import tn.esprit.kaddem.entities.Universite;
import tn.esprit.kaddem.repository.DepartementRepository;
import tn.esprit.kaddem.repository.UniversiteRepository;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class DepartementServiceImp implements IDepartementServices {


    DepartementRepository departementRepository;
    UniversiteRepository universiteRepository;


    @Override
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }


    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public void deleteDepartement(Integer idDepart) {
        departementRepository.deleteById(idDepart);
    }

    @Override
    public Departement getDepartementById(Integer idDepart) {
        return departementRepository.findById(idDepart).orElse(null);
    }

    @Override
    public List<Departement> retrieveDepartementByOptionEtudiant(Option opt) {
        return departementRepository.retrieveDepartementByOptionEtudiant(opt);
    }

   @Override
    public Set<Departement> retrieveDepartementByUniversite(Integer idUniversite){
        Universite uni = universiteRepository.findById(idUniversite).orElse(null);
        return uni.getDepartements();
    }
}
