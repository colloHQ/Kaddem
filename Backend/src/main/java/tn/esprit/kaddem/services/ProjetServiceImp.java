package tn.esprit.kaddem.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entities.Entreprise;
import tn.esprit.kaddem.entities.Projet;
import tn.esprit.kaddem.entities.Review;
import tn.esprit.kaddem.entities.Universite;
import tn.esprit.kaddem.repository.EntrepriseRepository;
import tn.esprit.kaddem.repository.ProjetRepository;

import java.util.List;
@Service
@AllArgsConstructor

public class ProjetServiceImp implements IProjetService{

    ProjetRepository projetRepository;
    EntrepriseRepository entrepriseRepository;
    @Override
    public List<Projet> getAllProjet() {
        return projetRepository.findAll();
    }

    @Override
    public Projet addProjet(Projet p) {
        p.setReview(Review.NOTYETREVIEWED);
        return projetRepository.save(p);
    }

    @Override
    public Projet updateProjet(Projet p) {
        return projetRepository.save(p);
    }

    @Override
    public void deleteProjet(Long idProjet) {
        projetRepository.deleteById(idProjet);
    }

    @Override
    public Projet getProjet(Long idProjet) {
        return projetRepository.findById(idProjet).orElse(null);
    }

    @Override
    public Projet addAndAssignProjetToEntreprise(Projet p, Long idEntreprise) {
        Entreprise e = entrepriseRepository.findById(idEntreprise).orElse(null);
        p.setEntrepriseP(e);
        return projetRepository.save(p);
    }
}

