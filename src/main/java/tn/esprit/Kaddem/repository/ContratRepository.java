package tn.esprit.Kaddem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Kaddem.entities.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Integer> {

}