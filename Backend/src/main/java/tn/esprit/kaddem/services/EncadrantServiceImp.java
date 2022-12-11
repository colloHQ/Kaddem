package tn.esprit.kaddem.services;

import java.util.List;
import java.util.stream.Collectors;

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
    
}
