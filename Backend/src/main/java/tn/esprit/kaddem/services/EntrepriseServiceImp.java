package tn.esprit.kaddem.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entities.Entreprise;
import tn.esprit.kaddem.entities.Projet;
import tn.esprit.kaddem.entities.Review;
import tn.esprit.kaddem.repository.EntrepriseRepository;
import tn.esprit.kaddem.repository.EquipeRepository;
import tn.esprit.kaddem.repository.ProjetRepository;

import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
public class EntrepriseServiceImp implements IEntrepriseServices {

    EntrepriseRepository entrepriseRepository;
    ProjetRepository projetRepository;
    EquipeRepository equipeRepository;

    @Override
    public List<Entreprise> getAllEntreprise() {
        return entrepriseRepository.findAll();
    }

    @Override
    public Entreprise addEntreprise(Entreprise e) {
        return entrepriseRepository.save(e);
    }

    @Override
    public Entreprise updateEntreprise(Entreprise e) {
        return entrepriseRepository.save(e);
    }

    @Override
    public void deleteEntreprise(Long id) {
        entrepriseRepository.deleteById(id);
    }

    @Override
    public Entreprise getEntrepriseById(Long id) {
        return entrepriseRepository.findById(id).orElse(null);
    }

    @Override
    public Projet reviewProjet(Long idProjet, Review review) {
        Projet p = projetRepository.findById(idProjet).orElse(null);
        p.setReview(review);
        return projetRepository.save(p);
    }
    @Override
    public Entreprise getBestEntrepriseOfTheYear(int y) {
        HashMap<Long, Integer> EnbP = new HashMap<>();
        List<Entreprise> allEntreprise = entrepriseRepository.findAll();
        List<Projet> allProjetofyear = projetRepository.getProjetOfYear(y);
        for (Entreprise e : allEntreprise) {
            int nbprojet = 0;
            for (Projet p : allProjetofyear) {
                if (p.getEntrepriseP().getIdEntreprise() == e.getIdEntreprise()) {
                    nbprojet++;
                }
            }
            EnbP.put(e.getIdEntreprise(), nbprojet);
        }
/*
        for (Entreprise e : allEntreprise){
            allProjetofyear.forEach(projet -> {
                /*Set<Projet> projetsOfOneYear = allProjetofyear.stream()
                        .filter(p -> p.getDateDebutProjet().toString().substring(0,4)
                                .equals(p.getDateFinProjet().toString().substring(0,4)) )
                        .collect(Collectors.toSet());
               // EnbP.put(e.getIdEntreprise(), allProjetofyear.size());
                System.out.println(e.getIdEntreprise()+"nb projet  : "+projet.getIdProjet());
            });
        }*/
        EnbP.entrySet().forEach(entry -> {
            System.out.println("idEntreprise : " + entry.getKey() + " " + " nb projets of the year " + y + " " + entry.getValue());
        });

        Long idE = EnbP.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        Entreprise bestEntreprise = entrepriseRepository.findById(idE).orElse(null);

        return bestEntreprise;
    }
}