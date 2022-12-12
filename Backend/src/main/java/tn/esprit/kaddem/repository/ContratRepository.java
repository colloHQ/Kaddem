package tn.esprit.kaddem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.kaddem.entities.Contrat;

import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {
    @Modifying
    @Query(value = "SELECT * FROM Contrat RIGHT JOIN Etudiant on contrat.etudiant_id_etudiant = Etudiant.id_etudiant WHERE Etudiant.id_etudiant = :etudiantId", nativeQuery = true)
    List<Contrat> onDeleteEtudiant(@Param("etudiantId") Long etudiantId);

}
