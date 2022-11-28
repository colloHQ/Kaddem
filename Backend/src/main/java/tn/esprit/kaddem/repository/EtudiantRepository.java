package tn.esprit.kaddem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.kaddem.entities.Etudiant;
import tn.esprit.kaddem.entities.Option;

import java.util.List;
import java.util.Set;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Etudiant findEtudiantByPrenomEtudiant(String Prenom);


    @Query("SELECT etd FROM Etudiant etd"
            + " INNER JOIN etd.equips equipe "
            + " INNER JOIN DetailEquipe detailequip"
            + " ON detailequip.equipe = equipe.idEquipe"
            + " WHERE detailequip.thematique =:thematique")
    List<Etudiant> retrieveEtudiantByEquipeThematique(@Param("thematique") String thematique);

    @Modifying
    @Query("update Etudiant e set e.option = :op where e.idEtudiant =:idEtudiant")
    void updateEtudiantByOption(Option op, Long idEtudiant);

    Set<Etudiant> getEtudiantByDepartement(Integer idDepartement);
}
