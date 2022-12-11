package tn.esprit.kaddem.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entities.Departement;
import tn.esprit.kaddem.entities.Etudiant;
import tn.esprit.kaddem.entities.Option;
import tn.esprit.kaddem.entities.Universite;
import tn.esprit.kaddem.repository.DepartementRepository;
import tn.esprit.kaddem.repository.UniversiteRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public Set<Departement> retrieveDepartementByUniversite(Integer idUniversite) {
        Universite uni = universiteRepository.findById(idUniversite).orElse(null);
        return uni.getDepartements();
    }


    @Override
    public Map<Option, Long> getRepartitionEtudiantsParDepartement(Integer idDeprat) {
        Departement depart = departementRepository.findById(idDeprat).orElse(null);
        Set<Etudiant> listEtudiantDepart = depart.getEtudiants();
        long nbrEtudiantOption1 = listEtudiantDepart.stream().filter( e -> e.getOption().compareTo(Option.Gamix) == 0).count();
        long nbrEtudiantOption2 = listEtudiantDepart.stream().filter( e -> e.getOption().compareTo(Option.NIDS) == 0).count();
        long nbrEtudiantOption3 = listEtudiantDepart.stream().filter( e -> e.getOption().compareTo(Option.SAE) == 0).count();
        long nbrEtudiantOption4 = listEtudiantDepart.stream().filter( e -> e.getOption().compareTo(Option.SE) == 0).count();
        long nbrEtudiantOption5 = listEtudiantDepart.stream().filter( e -> e.getOption().compareTo(Option.TWIN) == 0).count();
        Map<Option, Long> repartitionEtudiants = new HashMap<Option, Long>();
        repartitionEtudiants.put(Option.Gamix, nbrEtudiantOption1);
        repartitionEtudiants.put(Option.NIDS, nbrEtudiantOption2);
        repartitionEtudiants.put(Option.SAE, nbrEtudiantOption3);
        repartitionEtudiants.put(Option.SE, nbrEtudiantOption4);
        repartitionEtudiants.put(Option.TWIN, nbrEtudiantOption5);
        return repartitionEtudiants;
    }
}
