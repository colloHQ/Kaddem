package tn.esprit.kaddem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.kaddem.entities.Departement;
import tn.esprit.kaddem.entities.Option;

import java.util.List;
import java.util.Set;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {

    @Query("SELECT dep FROM Departement dep INNER JOIN Etudiant etd ON etd.departement = dep.idDepartement WHERE etd.option =:op ")
    List<Departement> retrieveDepartementByOptionEtudiant(@Param("op") Option op);

    //Set<Departement> retrieveDepartementByUniversite(Integer idUniversite);

}
