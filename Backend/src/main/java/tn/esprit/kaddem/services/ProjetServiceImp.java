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

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
    public Projet addProjet(Projet p, Long id) {
        p.setStatus(Status.NotAffected);
        Entreprise entreprise = entrepriseRepository.findById(id).orElse(null);
        p.setEntrepriseP(entreprise);
        return projetRepository.save(p);
    }

    @Override
    public Projet updateProjet(Projet p, int id2) {
        Equipe equipe = equipeRepository.findById(id2).orElse(null);
        p.setEquipe(equipe);
        p.setStatus(Status.InProgress);
        return projetRepository.save(p);
    }

    @Override
    public Projet statusToFinished(Projet p) {
        p.setStatus(Status.finished);
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
    public Projet addAndAssignProjetToEquipe(Projet p, int idEquipe) {
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        p.setEquipe(equipe);
        p.setStatus(Status.InProgress);
        return projetRepository.save(p);
    }

    @Override
    public List<Projet> getProjetOfYear(int y) {
        return projetRepository.getProjetOfYear(y);
    }

    @Override
    public List<Projet> getProjetOrdredBYDateFin() {
        return projetRepository.findAllByOrderByDateFinProjetAsc();
    }

    @Override
    public double getPrixParEntreprise(Long idEntreprise) {
        List<Projet> projet;
        projet = projetRepository.findAll().stream()
                .filter(p -> p.getEntrepriseP().getIdEntreprise() == idEntreprise.valueOf(idEntreprise))
                .collect(Collectors.toList());


        return projet.stream().collect(Collectors.summingDouble(p -> p.getPrixProjet()));
    }

    @Override
    public List<Object> getmapPrixForEntreprise() {
        return projetRepository.getmapPrixForEntreprise();
    }

    @Override
    public void majorationProjet() {
        LocalDate Today = LocalDate.now();
        List<Projet> allProjet = projetRepository.findAll();
        for (Projet projet : allProjet) {
            if ((projet.getDateFinProjet().compareTo(Today) < 0) && (projet.getStatus().toString().equals("InProgress"))) {
                projet.setPrixProjet((projet.getPrixProjet() * 60) / 100);
                projetRepository.save(projet);

            }


        }
    }
}