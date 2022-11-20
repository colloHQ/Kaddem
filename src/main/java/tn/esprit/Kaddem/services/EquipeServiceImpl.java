package tn.esprit.Kaddem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Kaddem.entities.Equipe;
import tn.esprit.Kaddem.entities.Etudiant;
import tn.esprit.Kaddem.repository.EquipeRepository;
import tn.esprit.Kaddem.repository.EtudiantRepository;

import java.util.List;

@Service
public class EquipeServiceImpl implements IEquipeService {
    @Autowired
    EquipeRepository er;
    @Autowired
    EtudiantRepository ER;

    @Override
    public List<Equipe> retrieveAllEquipes() {
        return er.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return er.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return er.save(e);
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return er.findById(idEquipe).orElse(null);
    }

    @Override
    public void removeEquipe(Integer idEquipe) {
        er.deleteById(idEquipe);

    }

    @Override
    public void assignEtudiantToEquipe(Integer idEtudiant, Integer idEquipe) {
        Equipe equipe = er.findById(idEquipe).orElse(null);
        Etudiant etudiant = ER.findById(idEtudiant.longValue()).orElse(null);

    }

    @Override
    public List<Equipe> findEquipeByEtudiantsIdEtudiant(long idEtudiant) {
        return er.findEquipeByEtudiantsIdEtudiant(idEtudiant);
    }

}