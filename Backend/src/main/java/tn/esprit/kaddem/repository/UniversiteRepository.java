package tn.esprit.kaddem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.kaddem.entities.Universite;

public interface UniversiteRepository extends JpaRepository<Universite, Integer> {
}
