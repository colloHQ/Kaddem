package tn.esprit.Kaddem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Kaddem.entities.Contrat;
import tn.esprit.Kaddem.entities.Etudiant;
import tn.esprit.Kaddem.repository.ContratRepository;
import tn.esprit.Kaddem.repository.EtudiantRepository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ContratServiceImp implements IContratService {
    @Autowired
    ContratRepository cr;
    @Autowired
    EtudiantRepository er;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return cr.findAll();
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return cr.save(ce);
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
        return cr.save(ce);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return cr.findById(idContrat).orElse(null);
    }

    @Override
    public void removeContrat(Integer idContrat) {
        cr.deleteById(idContrat);
    }

    @Override
    public void assignEtudiantToContrat(Integer idEtudiant, Integer idContrat) {
        Etudiant e = er.findById(idEtudiant.longValue()).orElse(null);
        Contrat c = cr.findById(idContrat).orElse(null);
        e.setContrats((Set<Contrat>) c);
        er.save(e);

    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        return null;
    }

}