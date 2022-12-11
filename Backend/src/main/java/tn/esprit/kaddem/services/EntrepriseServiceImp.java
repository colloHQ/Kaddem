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

/*    @Override
    public String getReviewEquipe(Integer idEquipe) {
        Equipe e = equipeRepository.findById(idEquipe).orElse(null);
        List<Projet> ProjetsOfEquipe = projetRepository.findProjetsByEquipeIdEquipe(e.getIdEquipe());
        float stat;
        String ReviewEquipe = "";
        int score = 0;
        for(int i=0;i<ProjetsOfEquipe.size();i++) {
            Projet p = ProjetsOfEquipe.get(i);
            if (p.getReview().toString().equals("VERYBAD")) {
                score = score + 1;
            } else if (p.getReview().toString().equals("BAD")) {
                score = score + 2;
            } else if (p.getReview().toString().equals("AVERAGE")) {
                score = score + 3;
            } else if (p.getReview().toString().equals("GOOD")) {
                score = score + 4;
            } else if (p.getReview().toString().equals("EXCELLENT")) {
                score = score + 5;
            }
        }
        System.out.println(score);
        stat = score / ProjetsOfEquipe.size();
        System.out.println(stat);
        if( stat == 1){
            ReviewEquipe = "L'equipe " + e.getNomEquipe() + " a le Review : VERYBAD";
        } else if( stat == 2){
            ReviewEquipe = "L'equipe " + e.getNomEquipe() + " a le Review : BAD";
        }else if( stat == 3){
            ReviewEquipe = "L'equipe " + e.getNomEquipe() + " a le Review : AVERAGE";
        }else if( stat == 4){
            ReviewEquipe = "L'equipe " + e.getNomEquipe() + " a le Review : GOOD";
        }else if( stat == 5){
            ReviewEquipe = "L'equipe " + e.getNomEquipe() + " a le Review : EXCELLENT";
        }
        return ReviewEquipe;
    }*/


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