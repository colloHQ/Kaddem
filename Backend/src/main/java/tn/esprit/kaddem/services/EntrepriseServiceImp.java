package tn.esprit.kaddem.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.kaddem.entities.*;
import tn.esprit.kaddem.repository.EntrepriseRepository;
import tn.esprit.kaddem.repository.EquipeRepository;
import tn.esprit.kaddem.repository.ProjetRepository;

import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public String  PourcentageDeparticipationSelonSecteur(Secteur secteur) {

        List<Entreprise> AllEpseOfSameSecteur = entrepriseRepository.findAllBySecteur(secteur);
        String statistique="";
        Long nbProjetDeSecteur = projetRepository.findAll().stream()
                .filter(projet -> projet.getEntrepriseP().getSecteur().compareTo(secteur)==0).count();
        System.out.println(nbProjetDeSecteur);
        for (Entreprise e : AllEpseOfSameSecteur){
            int Pe = e.getProjets().size();
            double p = (Pe*100)/nbProjetDeSecteur;
            statistique+="L'entreprise "+ e.getNomEntreprise()+" participe avec "+Pe
            +" projets dans le secteur "+secteur+". pourcentage : "+p+"% \n";
        }

        return statistique;
    }

    @Override
    public List<Entreprise> findByProjetsIsNull() {
        return entrepriseRepository.findByProjetsIsNull();
    }

    @Override
    public Map<String, Set<String>> GetAllEquipsOfAllEntreprises() {
        Map<String,Set<String>> equipsOfEntreprise = new HashMap<>();
        List<Entreprise> allE = entrepriseRepository.findAll();
        allE.forEach(entreprise -> {
            Set<Projet> Eprojets = entreprise.getProjets();
            Set<String> NameEquips = new HashSet<>();
            Eprojets.forEach(projet -> {
                NameEquips.add(projet.getEquipe().getNomEquipe());
            });
                  equipsOfEntreprise.put(entreprise.getNomEntreprise(),NameEquips);
        });


        return equipsOfEntreprise;
    }



}