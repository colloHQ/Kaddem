package tn.esprit.kaddem.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.esprit.kaddem.entities.Encadrant;
import tn.esprit.kaddem.entities.Equipe;
import tn.esprit.kaddem.entities.Niveau;
import tn.esprit.kaddem.repository.EncadrantRepository;
import tn.esprit.kaddem.repository.EquipeRepository;

@Service
@AllArgsConstructor
public class EncadrantServiceImp implements IEncadrantServices{

    EncadrantRepository encadrantRepository;
    EquipeRepository equipeRepository;

    @Override
    public List<Encadrant> getAllEncadrants() {
        return encadrantRepository.findAll();
    }

    @Override
    public Encadrant addEncadrant(Encadrant en) {
        return encadrantRepository.save(en);
    }

    @Override
    public Encadrant updateEncadrant(Encadrant en) {
        return encadrantRepository.save(en);
    }

    @Override
    public void deleteEncadrant(Integer idEncadrant) {
        encadrantRepository.deleteById(idEncadrant);
    }

    @Override
    public Encadrant getEncadrantById(Integer idEncadrant) {
        return encadrantRepository.findById(idEncadrant).orElse(null);
    }

    @Override
    public List<Encadrant> getEncadrantsByNiveauEquipe(String niveau) {
        List<Equipe> equipesByNiveau = equipeRepository.findAll()
            .stream()
            .filter( equipe -> equipe.getNiveau() == Niveau.valueOf(niveau))
            .collect(Collectors.toList());
        return equipesByNiveau.stream()
            .map( equipe -> equipe.getEncadrant())
            .collect(Collectors.toList());
    }

    @Override
    public void addAndAssignEncadrantToEquipe(Integer idEquipe, Encadrant en) {
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        encadrantRepository.save(en);
        equipe.setEncadrant(en);
        equipeRepository.save(equipe);        
    }

    @Override
    public Map<String, Double> calculPrimeAnnuelEncadrant() {
        Map<String, Double> primeAnnuelParEncadrant = new HashMap<>();
        List<Encadrant> encadrants = encadrantRepository.findAll();
        encadrants.forEach( en -> {
            List<Double> primeAnnuelParProjet = new ArrayList<>();
            en.getEquipes().forEach(eq -> {
                eq.getProjets().forEach( pr -> {
                    if(eq.getNiveau() == Niveau.JUNIOR) primeAnnuelParProjet.add(pr.getPrixProjet() * 0.1);
                    else if(eq.getNiveau() == Niveau.SENIOR) primeAnnuelParProjet.add(pr.getPrixProjet() * 0.2);
                    else primeAnnuelParProjet.add(pr.getPrixProjet() * 0.3);
                });
            });
            primeAnnuelParEncadrant.put(
                en.getNomEncadrant(), 
                primeAnnuelParProjet.stream().mapToDouble(Double::valueOf).sum() / primeAnnuelParProjet.size());
        });
        return primeAnnuelParEncadrant;
    }

    
    
}
