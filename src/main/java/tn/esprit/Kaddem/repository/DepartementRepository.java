package tn.esprit.Kaddem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Kaddem.entities.Departement;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Integer> {
}