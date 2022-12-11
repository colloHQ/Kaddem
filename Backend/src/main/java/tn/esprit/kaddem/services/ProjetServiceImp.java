package tn.esprit.kaddem.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entities.Entreprise;
import tn.esprit.kaddem.entities.Equipe;
import tn.esprit.kaddem.entities.Projet;
import tn.esprit.kaddem.entities.Status;
import tn.esprit.kaddem.repository.EntrepriseRepository;
import tn.esprit.kaddem.repository.EquipeRepository;
import tn.esprit.kaddem.repository.ProjetRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class ProjetServiceImp implements IProjetServices {

    private final EquipeRepository equipeRepository;
    ProjetRepository projetRepository;
    EntrepriseRepository entrepriseRepository;

    @Override
    public List<Projet> getAllProjet() {
        return projetRepository.findAll();
    }

    @Override
    public Projet addProjet(Projet p) {
        p.setStatus(Status.NotAffected);
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
    public Projet addAndAssignProjetToEquipeAndEntreprise(Projet p, int idEquipe, Long idEntreprise) {
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        Entreprise entreprise = entrepriseRepository.findById(idEntreprise).orElse(null);
        p.setEquipe(equipe);
        p.setEntrepriseP(entreprise);
        p.setStatus(Status.InProgress);
        return projetRepository.save(p);
    }

    @Override
    public List<Projet> getProjetOfYear(int y) {
        return projetRepository.getProjetOfYear(y);
    }

    @Override
    public Projet getProjetOrdredBYDateFin() {
        return projetRepository.findAllByOrderByDateFinProjetAsc();
    }
}