package tn.esprit.Kaddem.services;


import tn.esprit.Kaddem.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratService {
    List<Contrat> retrieveAllContrats();

    Contrat addContrat(Contrat ce);

    Contrat updateContrat(Contrat ce);

    Contrat retrieveContrat(Integer idContrat);

    void removeContrat(Integer idContrat);

    void assignEtudiantToContrat(Integer idEtudiant, Integer idContrat);

    Integer nbContratsValides(Date startDate, Date endDate);
}