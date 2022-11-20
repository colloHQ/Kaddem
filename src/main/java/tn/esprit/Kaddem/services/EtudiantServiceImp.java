package tn.esprit.Kaddem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Kaddem.entities.Etudiant;
import tn.esprit.Kaddem.repository.EtudiantRepository;

import java.util.List;

@Service
public class EtudiantServiceImp implements IEtudiantService {

    @Autowired
    EtudiantRepository etudiantRepositotry;

    @Override
    public List<Etudiant> getAllEtudiant() {
        return etudiantRepositotry.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepositotry.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepositotry.save(e);
    }

    @Override
    public void deleteEtudiant(Long id) {
        etudiantRepositotry.deleteById(id);
    }

    @Override
    public Etudiant getEtudiantById(Long id) {
        return etudiantRepositotry.findById(id).orElse(null);
    }

    @Override
    public Etudiant findByPrenomE(String prenomE) {
        return etudiantRepositotry.findByPrenomE(prenomE);
    }


}