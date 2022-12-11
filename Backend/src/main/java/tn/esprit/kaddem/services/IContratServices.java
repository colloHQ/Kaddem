package tn.esprit.kaddem.services;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.kaddem.entities.Contrat;
import tn.esprit.kaddem.entities.Niveau;
import tn.esprit.kaddem.entities.Specialite;

import java.util.Date;
import java.util.List;

public interface IContratServices {
    List<Contrat> getALLContrat();

    Contrat addContrat(Contrat c);

    Contrat updateContrat(Contrat c);

    void deleteContrat(Integer id);

    Contrat getContratById(Integer id);

    Contrat affectContratToEtudiant(Contrat contrat, String nomE,  String prenomE);

    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);

    public Integer nbContratsValides(Date startDate, Date endDate);
    List<Contrat> getContractsBySpecialite(Specialite specialite);
    void archiveDeadContracts();
    String retrieveAndUpdateStatusContrat();

   void onDeleteEtudiant(@Param("etudiantId") Long etudiantId);

}
