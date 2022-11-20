package tn.esprit.Kaddem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Kaddem.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    Etudiant findByPrenomE(String prenomE);


}